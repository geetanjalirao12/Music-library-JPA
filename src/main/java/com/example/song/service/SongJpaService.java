/*
 * You can use the following import statements
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 */

// Write your code here

package com.example.song.service;
import com.example.song.model.Song;
import com.example.song.repository.SongRepository;
import com.example.song.repository.SongJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import javax.validation.Valid;

@Service
public class SongJpaService implements SongRepository{
    @Autowired
    private SongJpaRepository songJpaRepository;

    @Override
    public ArrayList<Song> getSongs(){
        List<Song> songsList=songJpaRepository.findAll();
        ArrayList<Song> songs=new ArrayList<>(songsList);
        return songs;
    }

    @Override

    public Song getSongById(int songId){
        try{
            Song song=songJpaRepository.findById(songId).get();
            return song;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        
    }

    @Override
    public Song addSong(Song song){
        songJpaRepository.save(song);
        return song;

    }

    @Override

    public Song updateSong(int songId,Song song){
        try{
            Song newSong=songJpaRepository.findById(songId).get();
            if(song.getSongName() != null){
                newSong.setSongName(song.getSongName());
            }
            if(song.getLyricist() != null){
                newSong.setLyricist(song.getLyricist());
            }
            if(song.getSinger() != null){
                newSong.setSinger(song.getSinger());
            }
            if(song.getMusicDirector() != null){
                newSong.setMusicDirector(song.getMusicDirector());
            }
            return newSong;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        
    }

    @Override
    public void deleteSong(int songId){
        try{
            songJpaRepository.deleteById(songId);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }
    
}