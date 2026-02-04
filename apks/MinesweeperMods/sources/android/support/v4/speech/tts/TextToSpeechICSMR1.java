package android.support.v4.speech.tts;

import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes2.dex */
class TextToSpeechICSMR1 {
    public static final String KEY_FEATURE_EMBEDDED_SYNTHESIS = "embeddedTts";
    public static final String KEY_FEATURE_NETWORK_SYNTHESIS = "networkTts";

    interface UtteranceProgressListenerICSMR1 {
        void onDone(String str);

        void onError(String str);

        void onStart(String str);
    }

    TextToSpeechICSMR1() {
    }

    static Set getFeatures(TextToSpeech textToSpeech, Locale locale) {
        if (Build.VERSION.SDK_INT >= 15) {
            return textToSpeech.getFeatures(locale);
        }
        return null;
    }

    static void setUtteranceProgressListener(TextToSpeech textToSpeech, final UtteranceProgressListenerICSMR1 utteranceProgressListenerICSMR1) {
        if (Build.VERSION.SDK_INT >= 15) {
            textToSpeech.setOnUtteranceProgressListener(new UtteranceProgressListener() { // from class: android.support.v4.speech.tts.TextToSpeechICSMR1.1
                @Override // android.speech.tts.UtteranceProgressListener
                public final void onDone(String str) {
                    utteranceProgressListenerICSMR1.onDone(str);
                }

                @Override // android.speech.tts.UtteranceProgressListener
                public final void onError(String str) {
                    utteranceProgressListenerICSMR1.onError(str);
                }

                @Override // android.speech.tts.UtteranceProgressListener
                public final void onStart(String str) {
                    utteranceProgressListenerICSMR1.onStart(str);
                }
            });
        } else {
            textToSpeech.setOnUtteranceCompletedListener(new TextToSpeech.OnUtteranceCompletedListener() { // from class: android.support.v4.speech.tts.TextToSpeechICSMR1.2
                @Override // android.speech.tts.TextToSpeech.OnUtteranceCompletedListener
                public final void onUtteranceCompleted(String str) {
                    utteranceProgressListenerICSMR1.onStart(str);
                    utteranceProgressListenerICSMR1.onDone(str);
                }
            });
        }
    }
}
