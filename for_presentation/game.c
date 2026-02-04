#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <ctype.h>

#define MAP_SIZE 10
#define MAX_INVENTORY 10
#define MAX_ENEMIES 5

// Game structures
typedef struct {
    char name[20];
    int health;
    int maxHealth;
    int attack;
    int defense;
    int xp;
    int level;
    int gold;
    int potions;
    int x, y;
} Player;

typedef struct {
    char name[20];
    int health;
    int attack;
    int defense;
    int xpReward;
    int goldReward;
} Enemy;

typedef struct {
    char name[20];
    char type; // 'W' weapon, 'A' armor, 'P' potion, 'K' key
    int value;
} Item;

// Game state
typedef struct {
    char map[MAP_SIZE][MAP_SIZE];
    Player player;
    Item inventory[MAX_INVENTORY];
    int inventoryCount;
    int bossDefeated;
    int gameRunning;
} GameState;

// Function prototypes
void initializeGame(GameState *game);
void drawMap(GameState *game);
void drawStats(GameState *game);
void handleMovement(GameState *game, char direction);
void handleEncounter(GameState *game);
int combat(Player *player, Enemy *enemy);
void levelUp(Player *player);
void showInventory(GameState *game);
void useItem(GameState *game, int index);
void addItem(GameState *game, Item item);
void generateRandomItem(Item *item);
Enemy generateRandomEnemy(int area);
void drawTitle();
void saveGame(GameState *game);
int loadGame(GameState *game);

int main() {
    GameState game;
    char input;
    
    srand(time(NULL));
    
    drawTitle();
    
    printf("1. New Game\n");
    printf("2. Load Game\n");
    printf("Choice: ");
    scanf(" %c", &input);
    
    if (input == '2') {
        if (!loadGame(&game)) {
            printf("No saved game found. Starting new game.\n");
            initializeGame(&game);
        }
    } else {
        initializeGame(&game);
    }
    
    // Game loop
    while (game.gameRunning) {
        system("clear || cls");
        
        drawStats(&game);
        drawMap(&game);
        
        printf("\nCommands: [W]Up [S]Down [A]Left [D]Right [I]Inventory [Q]Quit\n");
        printf("Enter command: ");
        scanf(" %c", &input);
        
        input = toupper(input);
        
        switch(input) {
            case 'W':
            case 'S':
            case 'A':
            case 'D':
                handleMovement(&game, input);
                break;
            case 'I':
                showInventory(&game);
                break;
            case 'Q':
                game.gameRunning = 0;
                printf("Would you like to save? (Y/N): ");
                scanf(" %c", &input);
                if (toupper(input) == 'Y') {
                    saveGame(&game);
                }
                break;
            default:
                printf("Invalid command!\n");
                printf("Press Enter to continue...");
                getchar(); getchar();
        }
        
        // Check win condition
        if (game.bossDefeated) {
            system("clear || cls");
            printf("\n╔══════════════════════════════════════════╗\n");
            printf("║          VICTORY ACHIEVED!              ║\n");
            printf("╠══════════════════════════════════════════╣\n");
            printf("║ You have defeated the dungeon boss!     ║\n");
            printf("║ Your score: %d gold, Level %d           ║\n", 
                   game.player.gold, game.player.level);
            printf("║                                          ║\n");
            printf("║   Thank you for playing Dungeon Crawl!  ║\n");
            printf("╚══════════════════════════════════════════╝\n");
            game.gameRunning = 0;
        }
        
        // Check death
        if (game.player.health <= 0) {
            system("clear || cls");
            printf("\n╔══════════════════════════════════════════╗\n");
            printf("║            YOU DIED!                     ║\n");
            printf("╠══════════════════════════════════════════╣\n");
            printf("║ You reached Level %d                     ║\n", game.player.level);
            printf("║ Collected %d gold                       ║\n", game.player.gold);
            printf("║                                          ║\n");
            printf("║        GAME OVER                         ║\n");
            printf("╚══════════════════════════════════════════╝\n");
            game.gameRunning = 0;
        }
    }
    
    return 0;
}

void initializeGame(GameState *game) {
    // Initialize player
    strcpy(game->player.name, "Hero");
    game->player.maxHealth = 50;
    game->player.health = game->player.maxHealth;
    game->player.attack = 10;
    game->player.defense = 5;
    game->player.xp = 0;
    game->player.level = 1;
    game->player.gold = 0;
    game->player.potions = 3;
    game->player.x = MAP_SIZE / 2;
    game->player.y = MAP_SIZE / 2;
    
    // Initialize map
    for (int i = 0; i < MAP_SIZE; i++) {
        for (int j = 0; j < MAP_SIZE; j++) {
            if (i == 0 || i == MAP_SIZE-1 || j == 0 || j == MAP_SIZE-1) {
                game->map[i][j] = '#'; // Walls
            } else {
                game->map[i][j] = '.'; // Empty space
            }
        }
    }
    
    // Place special tiles
    game->map[1][1] = 'B'; // Boss
    game->map[1][MAP_SIZE-2] = 'C'; // Chest
    game->map[MAP_SIZE-2][1] = 'H'; // Healing fountain
    game->map[MAP_SIZE-2][MAP_SIZE-2] = 'S'; // Shop
    
    // Add starting items
    Item sword = {"Iron Sword", 'W', 5};
    Item armor = {"Leather Armor", 'A', 3};
    Item potion = {"Health Potion", 'P', 20};
    
    game->inventoryCount = 0;
    addItem(game, sword);
    addItem(game, armor);
    addItem(game, potion);
    
    game->bossDefeated = 0;
    game->gameRunning = 1;
}

void drawTitle() {
    system("clear || cls");
    printf("\n╔══════════════════════════════════════════╗\n");
    printf("║         DUNGEON CRAWL ADVENTURE         ║\n");
    printf("╠══════════════════════════════════════════╣\n");
    printf("║ A roguelike RPG adventure in C!         ║\n");
    printf("║ Find and defeat the boss (B) to win!    ║\n");
    printf("╚══════════════════════════════════════════╝\n");
    printf("\nSymbols: @=You, #=Wall, .=Floor, B=Boss\n");
    printf("         C=Chest, H=Heal, S=Shop, E=Enemy\n");
    printf("\nPress Enter to continue...");
    getchar();
}

void drawStats(GameState *game) {
    printf("\n══════════════════════════════════════════\n");
    printf("HERO: %-15s LEVEL: %d\n", game->player.name, game->player.level);
    printf("HP: %3d/%-3d      XP: %d/%d\n", 
           game->player.health, game->player.maxHealth,
           game->player.xp, game->player.level * 100);
    printf("ATK: %-3d DEF: %-3d   GOLD: %d\n", 
           game->player.attack, game->player.defense, game->player.gold);
    printf("══════════════════════════════════════════\n");
}

void drawMap(GameState *game) {
    printf("\n");
    for (int i = 0; i < MAP_SIZE; i++) {
        for (int j = 0; j < MAP_SIZE; j++) {
            if (i == game->player.y && j == game->player.x) {
                printf("@ "); // Player
            } else {
                printf("%c ", game->map[i][j]);
            }
        }
        printf("\n");
    }
}

void handleMovement(GameState *game, char direction) {
    int newX = game->player.x;
    int newY = game->player.y;
    
    switch(direction) {
        case 'W': newY--; break;
        case 'S': newY++; break;
        case 'A': newX--; break;
        case 'D': newX++; break;
    }
    
    // Check boundaries
    if (newX < 0 || newX >= MAP_SIZE || newY < 0 || newY >= MAP_SIZE) {
        printf("You hit a wall!\n");
        return;
    }
    
    // Check for walls
    if (game->map[newY][newX] == '#') {
        printf("You hit a wall!\n");
        return;
    }
    
    // Move player
    game->player.x = newX;
    game->player.y = newY;
    
    // Handle tile events
    char tile = game->map[newY][newX];
    
    switch(tile) {
        case 'E':
            handleEncounter(game);
            game->map[newY][newX] = '.'; // Remove enemy after encounter
            break;
            
        case 'C':
            printf("\nYou found a chest!\n");
            Item foundItem;
            generateRandomItem(&foundItem);
            addItem(game, foundItem);
            printf("Found: %s!\n", foundItem.name);
            game->map[newY][newX] = '.';
            break;
            
        case 'H':
            printf("\nYou found a healing fountain!\n");
            game->player.health = game->player.maxHealth;
            printf("Health fully restored!\n");
            break;
            
        case 'S':
            printf("\nWelcome to the shop!\n");
            printf("You have %d gold\n", game->player.gold);
            printf("1. Health Potion (20 gold) - Restores 20 HP\n");
            printf("2. Better Sword (50 gold) - +5 Attack\n");
            printf("3. Better Armor (50 gold) - +5 Defense\n");
            printf("4. Leave shop\n");
            printf("Choice: ");
            
            char choice;
            scanf(" %c", &choice);
            
            switch(choice) {
                case '1':
                    if (game->player.gold >= 20) {
                        game->player.gold -= 20;
                        Item potion = {"Health Potion", 'P', 20};
                        addItem(game, potion);
                        printf("Bought Health Potion!\n");
                    } else {
                        printf("Not enough gold!\n");
                    }
                    break;
                    
                case '2':
                    if (game->player.gold >= 50) {
                        game->player.gold -= 50;
                        game->player.attack += 5;
                        printf("Attack increased by 5!\n");
                    } else {
                        printf("Not enough gold!\n");
                    }
                    break;
                    
                case '3':
                    if (game->player.gold >= 50) {
                        game->player.gold -= 50;
                        game->player.defense += 5;
                        printf("Defense increased by 5!\n");
                    } else {
                        printf("Not enough gold!\n");
                    }
                    break;
            }
            printf("Press Enter to continue...");
            getchar(); getchar();
            break;
            
        case 'B':
            printf("\nBOSS ENCOUNTER!\n");
            Enemy boss = {"Dragon Lord", 100, 20, 10, 200, 100};
            if (combat(&game->player, &boss)) {
                game->bossDefeated = 1;
                game->map[newY][newX] = '.';
            }
            break;
            
        case '.':
            // 30% chance of random encounter
            if ((rand() % 100) < 30) {
                game->map[newY][newX] = 'E';
                printf("An enemy appears!\n");
                handleEncounter(game);
                game->map[newY][newX] = '.';
            }
            break;
    }
}

void handleEncounter(GameState *game) {
    int area = game->player.level;
    Enemy enemy = generateRandomEnemy(area);
    
    printf("\nA wild %s appears!\n", enemy.name);
    printf("HP: %d, ATK: %d, DEF: %d\n", enemy.health, enemy.attack, enemy.defense);
    printf("Prepare for combat!\n");
    
    if (combat(&game->player, &enemy)) {
        printf("You defeated the %s!\n", enemy.name);
        printf("+%d XP, +%d Gold\n", enemy.xpReward, enemy.goldReward);
        
        game->player.xp += enemy.xpReward;
        game->player.gold += enemy.goldReward;
        
        // Check for level up
        if (game->player.xp >= game->player.level * 100) {
            levelUp(&game->player);
        }
        
        // Chance for item drop
        if ((rand() % 100) < 25) {
            Item drop;
            generateRandomItem(&drop);
            addItem(game, drop);
            printf("The enemy dropped: %s!\n", drop.name);
        }
    }
    
    printf("Press Enter to continue...");
    getchar(); getchar();
}

int combat(Player *player, Enemy *enemy) {
    while (player->health > 0 && enemy->health > 0) {
        system("clear || cls");
        printf("\n════════════════════ COMBAT ════════════════════\n");
        printf("%s\n", enemy->name);
        printf("HP: %d/%d  ATK: %d  DEF: %d\n", 
               enemy->health, enemy->health, enemy->attack, enemy->defense);
        printf("\n%s\n", player->name);
        printf("HP: %d/%d  ATK: %d  DEF: %d\n", 
               player->health, player->maxHealth, player->attack, player->defense);
        printf("\n═══════════════════════════════════════════════\n");
        printf("1. Attack\n");
        printf("2. Use Item\n");
        printf("3. Flee (50%% chance)\n");
        printf("Choice: ");
        
        char choice;
        scanf(" %c", &choice);
        
        switch(choice) {
            case '1': {
                // Player attacks
                int damage = player->attack - (enemy->defense / 2);
                if (damage < 1) damage = 1;
                enemy->health -= damage;
                printf("You hit %s for %d damage!\n", enemy->name, damage);
                
                // Enemy attacks if alive
                if (enemy->health > 0) {
                    int enemyDamage = enemy->attack - (player->defense / 2);
                    if (enemyDamage < 1) enemyDamage = 1;
                    player->health -= enemyDamage;
                    printf("%s hits you for %d damage!\n", enemy->name, enemyDamage);
                }
                break;
            }
                
            case '2':
                // Would need item system implemented
                printf("Item system not fully implemented yet!\n");
                break;
                
            case '3':
                if ((rand() % 100) < 50) {
                    printf("You fled successfully!\n");
                    return 0;
                } else {
                    printf("Failed to flee!\n");
                    int enemyDamage = enemy->attack - (player->defense / 2);
                    if (enemyDamage < 1) enemyDamage = 1;
                    player->health -= enemyDamage;
                    printf("%s hits you for %d damage!\n", enemy->name, enemyDamage);
                }
                break;
        }
        
        printf("Press Enter to continue...");
        getchar(); getchar();
    }
    
    return player->health > 0;
}

void levelUp(Player *player) {
    player->level++;
    player->xp = 0;
    player->maxHealth += 10;
    player->health = player->maxHealth;
    player->attack += 2;
    player->defense += 1;
    
    printf("\n══════════════════════════════════════════\n");
    printf("            LEVEL UP!                     \n");
    printf("══════════════════════════════════════════\n");
    printf("You are now level %d!\n", player->level);
    printf("Max HP increased to %d\n", player->maxHealth);
    printf("Attack increased to %d\n", player->attack);
    printf("Defense increased to %d\n", player->defense);
    printf("══════════════════════════════════════════\n");
    printf("Press Enter to continue...");
    getchar(); getchar();
}

void showInventory(GameState *game) {
    system("clear || cls");
    printf("\n════════════════════ INVENTORY ════════════════════\n");
    
    if (game->inventoryCount == 0) {
        printf("Inventory is empty!\n");
    } else {
        for (int i = 0; i < game->inventoryCount; i++) {
            printf("%d. %-20s ", i + 1, game->inventory[i].name);
            switch(game->inventory[i].type) {
                case 'W': printf("(Weapon +%d ATK)\n", game->inventory[i].value); break;
                case 'A': printf("(Armor +%d DEF)\n", game->inventory[i].value); break;
                case 'P': printf("(Potion +%d HP)\n", game->inventory[i].value); break;
                case 'K': printf("(Key Item)\n"); break;
            }
        }
    }
    
    printf("\n═══════════════════════════════════════════════════\n");
    printf("Enter item number to use, or 0 to exit: ");
    
    int choice;
    scanf("%d", &choice);
    
    if (choice > 0 && choice <= game->inventoryCount) {
        useItem(game, choice - 1);
    }
}

void useItem(GameState *game, int index) {
    Item item = game->inventory[index];
    
    switch(item.type) {
        case 'P':
            game->player.health += item.value;
            if (game->player.health > game->player.maxHealth) {
                game->player.health = game->player.maxHealth;
            }
            printf("Used %s! Healed %d HP.\n", item.name, item.value);
            
            // Remove item from inventory
            for (int i = index; i < game->inventoryCount - 1; i++) {
                game->inventory[i] = game->inventory[i + 1];
            }
            game->inventoryCount--;
            break;
            
        case 'W':
            printf("You equip the %s (+%d ATK)\n", item.name, item.value);
            game->player.attack += item.value;
            break;
            
        case 'A':
            printf("You equip the %s (+%d DEF)\n", item.name, item.value);
            game->player.defense += item.value;
            break;
    }
    
    printf("Press Enter to continue...");
    getchar(); getchar();
}

void addItem(GameState *game, Item item) {
    if (game->inventoryCount < MAX_INVENTORY) {
        game->inventory[game->inventoryCount] = item;
        game->inventoryCount++;
    } else {
        printf("Inventory full! Could not pick up: %s\n", item.name);
    }
}

void generateRandomItem(Item *item) {
    int type = rand() % 3;
    int value = (rand() % 10) + 1;
    
    switch(type) {
        case 0:
            item->type = 'W';
            strcpy(item->name, "Steel Sword");
            item->value = value + 5;
            break;
        case 1:
            item->type = 'A';
            strcpy(item->name, "Chainmail");
            item->value = value + 3;
            break;
        case 2:
            item->type = 'P';
            strcpy(item->name, "Healing Potion");
            item->value = value * 5;
            break;
    }
}

Enemy generateRandomEnemy(int area) {
    Enemy enemy;
    char *names[] = {"Goblin", "Orc", "Skeleton", "Zombie", "Spider", "Wolf"};
    
    strcpy(enemy.name, names[rand() % 6]);
    enemy.health = (rand() % 20) + 10 + (area * 5);
    enemy.attack = (rand() % 5) + 5 + (area * 2);
    enemy.defense = (rand() % 5) + (area * 1);
    enemy.xpReward = (rand() % 30) + 10 + (area * 5);
    enemy.goldReward = (rand() % 20) + (area * 3);
    
    return enemy;
}

void saveGame(GameState *game) {
    FILE *file = fopen("savegame.dat", "wb");
    if (file) {
        fwrite(game, sizeof(GameState), 1, file);
        fclose(file);
        printf("Game saved successfully!\n");
    } else {
        printf("Error saving game!\n");
    }
}

int loadGame(GameState *game) {
    FILE *file = fopen("savegame.dat", "rb");
    if (file) {
        fread(game, sizeof(GameState), 1, file);
        fclose(file);
        printf("Game loaded successfully!\n");
        return 1;
    }
    return 0;
}
