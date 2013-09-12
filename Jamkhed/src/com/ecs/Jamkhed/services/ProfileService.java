package com.ecs.Jamkhed.services;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Base64Coder;
import com.badlogic.gdx.utils.Json;
import com.ecs.Jamkhed.Jamkhed;
import com.ecs.Jamkhed.domain.Profile;

public class ProfileService {
	private static final String PROFILE_DATA_FILE = "profile-v1.json";
	private Profile profile;
	
	public ProfileService(){
		
	}
	
	public Profile retrieveProfile(){
		Gdx.app.log(Jamkhed.LOG, "Retrieving profile");
		if(profile!=null) return profile;
		
		FileHandle profileDataFile = Gdx.files.local(PROFILE_DATA_FILE);
		Json json = new Json();
		
		if(profileDataFile.exists()){
			try{
				String profileAsCode = profileDataFile.readString();
				String profileAsText = Base64Coder.decodeString(profileAsCode);
				profile=json.fromJson(Profile.class, profileAsText);
			}catch(Exception e){
				Gdx.app.error(Jamkhed.LOG, "Unable to parse existing profile file");
				profile=new Profile();
				persist(profile);
			}
		} else {
			profile=new Profile();
			persist(profile);
		}
		return profile;
	}
	
	//Persists the given profile
	protected void persist(Profile profile){
		Gdx.app.log(Jamkhed.LOG, "Persisting profile");
		Json json=new Json();
		FileHandle profileDataFile = Gdx.files.local(PROFILE_DATA_FILE);
		String profileAsText = json.toJson(profile);
		String profileAsCode = Base64Coder.encodeString(profileAsText);
		profileDataFile.writeString(profileAsCode, false);
	}
	
	public void persist(){
		if(profile!=null)
				persist(profile);
	}
}
