package com.techelevator;

public class Television {

    private boolean isOn;
    private int selectedChannel = 3;
    private int currentVolume;

    /**
     * Current on/off status of the tv
     */
    public boolean IsOn() {
        return isOn;        
    }

    /**
     * Current selected channel number for the tv. Channels are 3 to 18.
     */
    public int getSelectedChannel() {
        return selectedChannel;            
    }


    /**
     * Current volume level for the tv. Volume level ranges from 0 to 10. 
     */
    public int getCurrentVolume() {
        return currentVolume;            
    }

    /**
     * Turns the tv on. Also resets the volume level to 2 
     */
    public void TurnOn()
    {
        isOn = true;                        
    }

    /**
     * Tuns the tv off. 
     */
    public void TurnOff()
    {
        isOn = false;
    }

    /**
     * Changes the tv channel, but only if it is on. 
     * @param newChannel new channel to turn to
     */
    public void ChangeChannel(int newChannel)
    {
        if (isOn && newChannel > 3 && newChannel < 18)
        {
            selectedChannel = newChannel;
        }
    }

    /**
     * Raises the volume. It won't raise it past 10 and the tv has to be on 
     */
    public void RaiseVolume()
    {
        currentVolume++;
    }

    /**
     * Lowers the volume. It won't lower it below 0 and the tv has to be on 
     */
    public void LowerVolume()
    {
        currentVolume--;
    }

}
