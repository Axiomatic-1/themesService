package com.microsevriceslesson.plateService.controller;

import com.microsevriceslesson.plateService.entity.Plate;
import com.microsevriceslesson.plateService.entity.References;
import com.microsevriceslesson.plateService.entity.Tags;
import com.microsevriceslesson.plateService.entity.UserProfile;
import com.microsevriceslesson.plateService.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/profile")
public class UserProfileController {

    @Autowired
    ProfileRepository profileRepository;

    @GetMapping("/example")
    public UserProfile getProfile(){
        Set<References> ref = new HashSet<>();
        ref.add(new References("vk.com", "social_media"));
        ref.add(new References("facebook.com", "social_media2"));
        Set<Tags> tag = new HashSet<>();
        tag.add(new Tags("tag"));
        Plate plate = new Plate();
        plate.setPlateName("Vk-Plate");
        plate.setReferences(ref);
        plate.setTag(tag);
        Set<Plate> plateSet = new HashSet<>();
        plateSet.add(plate);

        UserProfile profile = new UserProfile();
        profile.setPlates(plateSet);
        profile.setSubscribers(1L);
        profileRepository.save(profile);
        return profile;
    }



}
