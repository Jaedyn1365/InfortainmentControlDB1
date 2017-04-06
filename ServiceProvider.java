package com.example.spsnyder.premieredatabase.Data.Model;


public class ServiceProvider {

    public static final String TAG = ServiceProvider.class.getSimpleName();
    public static final String TABLE = "ServiceProvider";

    public static final String KEY_Provider_Id = "ProviderId";
    public static final String KEY_Provider_Name = "ProviderName";
    public static final String KEY_Channel_Number = "ChannelNumber";

    private String providerId;
    private String providerName;
    private String channelNumber;

    public String getChannelNumber(){
        return channelNumber;
    }

    public void setChannelNumber(String channelNumber){
        this.channelNumber = channelNumber;
    }

    public String getProviderName(){
        return providerName;
    }

    public void setProviderName(String providerName){
        this.providerName = providerName;
    }

    public String getProviderId(){
        return providerId;
    }

    public void setProviderId(String providerId){
        this.providerId = providerId;
    }
}
