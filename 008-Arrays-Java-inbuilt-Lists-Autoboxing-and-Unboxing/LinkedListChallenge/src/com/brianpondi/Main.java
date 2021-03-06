package com.brianpondi;

import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love don't mean a thing", 4.65);
        album.addSong("Holy man", 4.22);
        album.addSong("Hold on", 3.21);
        album.addSong("Lady double dealer", 6.23);
        album.addSong("You can't do it right", 5.60);
        album.addSong("High ball shooter", 6.16);
        album.addSong("The gypsy", 4.62);
        album.addSong("Soldier of fortune", 3.6);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 4.6);
        album.addSong("I put the finder on you", 4.65);
        album.addSong("Let's go", 4.22);
        album.addSong("Snowballed", 3.21);
        album.addSong("Inject the venom", 6.23);
        album.addSong("Evil walks", 5.6);
        album.addSong("C.O.D", 6.16);
        album.addSong("Breaking the rules", 4.62);
        album.addSong("Night of the long knives", 3.6);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlaylist("You can't do it right", playList);
        albums.get(0).addToPlaylist("Holy man", playList);
        albums.get(0).addToPlaylist("The Speed Geek", playList);// Doesnt exist
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(8, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(24, playList);// Doesnt exist

        play(playList);

    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        printMenu();
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No song in the playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("We are at the start of the list");
                        }
                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("Now replaying "+ listIterator.next().toString());
                            forward =true;
                        }else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next());
                        }else if(listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available actions: \n press");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions\n" +
                "6 - Delete current song from playlist.");
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("======================");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("=====================");
    }
}



