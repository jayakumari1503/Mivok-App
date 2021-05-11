package com.chhavi.miwok;

public class Word {
     //Miwok translation for the word
    private  String mMiwokTranslation;

    //Default translation for the word
    private String mDefaultTranslation;

    private static final int NO_IMAGE_PROVIDED = -1;
    private int mImageResourceID = NO_IMAGE_PROVIDED;

    private int mAudioResourceID;

    /**
     * create a new word object.
     *
     * @param defaultTranslation is a word in a language that a user already familiar with(such as English)
     * @param miwokTranslation is a word in the Miwok Language
     * @param audioResourceID to get audio of that word
     */
    public Word(String miwokTranslation, String defaultTranslation, int audioResourceID) {
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mAudioResourceID = audioResourceID;
    }

    public Word(String miwokTranslation, String defaultTranslation, int audioResourceID, int imageResourdeID) {
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mAudioResourceID = audioResourceID;
        mImageResourceID = imageResourdeID;
    }

    /**
     * Get the default translation of the word
     * @return default translation
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the miwok translation of the word
     * @return miwok translation
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Get audio of the miwok word
     * @return audio of miwok word
     */
    public int getAudioResourceID() {
        return mAudioResourceID;
    }

    public int getImageResourceID() {
        return mImageResourceID;
    }

    public boolean hasImage() {
        return mImageResourceID != NO_IMAGE_PROVIDED;
    }
}
