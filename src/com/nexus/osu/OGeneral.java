package com.nexus.osu;

public class OGeneral {
    public static final String AudioFilename = "AudioFilename";                         //	String	Location of the audio file relative to the current folder
    public static final String AudioLeadIn = "AudioLeadIn";                             //	Integer	Milliseconds of silence before the audio starts playing	0
    public static final String AudioHash = "AudioHash";                                 //	String	Deprecated
    public static final String PreviewTime = "PreviewTime";                         //	Integer	Time in milliseconds when the audio preview should start	-1
    public static final String Countdown = "Countdown";                                 //	Integer	Speed of the countdown before the first hit object (0 = no countdown, 1 = normal, 2 = half, 3 = double)	1
    public static final String SampleSet = "SampleSet";                                 //	String	Sample set that will be used if timing points do not override it (Normal, Soft, Drum)	Normal
    public static final String StackLeniency = "StackLeniency";                         //	Decimal	Multiplier for the threshold in time when hit objects placed close together stack (0–1)	0.7
    public static final String Mode = "Mode";                                           //	Integer	Game mode (0 = osu!, 1 = osu!taiko, 2 = osu!catch, 3 = osu!mania)	0
    public static final String LetterboxInBreaks = "LetterboxInBreaks";                 //	0 or 1	Whether breaks have a letterboxing effect	0
    public static final String StoryFireInFront = "StoryFireInFront";                   //	0 or 1	Deprecated	1
    public static final String UseSkinSprites = "UseSkinSprites";                       //	0 or 1	Whether the storyboard can use the user's skin images	0
    public static final String AlwaysShowPlayfield = "AlwaysShowPlayfield";             //	0 or 1	Deprecated	0
    public static final String OverlayPosition = "OverlayPosition";                     //	String	Draw order of hit circle overlays compared to hit numbers (NoChange = use skin setting, Below = draw overlays under numbers, Above = draw overlays on top of numbers)	NoChange
    public static final String SkinPreference = "SkinPreference";                       //	String	Preferred skin to use during gameplay
    public static final String EpilepsyWarning = "EpilepsyWarning";                     //	0 or 1	Whether a warning about flashing colours should be shown at the beginning of the map	0
    public static final String CountdownOffset = "CountdownOffset";                     //	Integer	Time in beats that the countdown starts before the first hit object	0
    public static final String SpecialStyle = "SpecialStyle";                           //	0 or 1	Whether the "N+1" style key layout is used for osu!mania	0
    public static final String WidescreenStoryboard = "WidescreenStoryboard";           //	0 or 1	Whether the storyboard allows widescreen viewing	0
    public static final String SamplesMatchPlaybackRate = "SamplesMatchPlaybackRate";   //	0 or 1	Whether sound samples will change rate when playing with speed-changing mods	0
}
