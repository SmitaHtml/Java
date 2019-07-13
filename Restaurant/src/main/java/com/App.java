package com;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;


public class App {

    //declare fields
    private static RestaurantRepository restaurantRepository;
    private static LocationRepository locationRepository;
    private static CuisineRepository cuisineRepository;
    private static AssociatedIdRepository associatedIdRepository;
    private static RestaurantLocationCuisineRepository restaurantLocationCuisineRepository;

    public static int menuOption = MainMenu();

    public static void main (String[] args) throws IOException {

        //initialize values
        Database database = new Database(); //IMPORTANT
        restaurantRepository = new RestaurantRepository(database); //IMPORTANT notice new and database
        locationRepository = new LocationRepository(database);
        cuisineRepository = new CuisineRepository(database);
        associatedIdRepository = new AssociatedIdRepository(database);
        restaurantLocationCuisineRepository = new RestaurantLocationCuisineRepository(database);

        //merges datasets of restaurant.json, location.json and cuisine.json into one restaurantlocationcuisine.json
        MergeAllRestaurantLocationCuisine();

        while (menuOption < 2) {
            switch (menuOption) {
                case 1:
                    Scanner scn = new Scanner(System.in);
                    System.out.println("Choose 1 2 or 3 from the following:\n  1. 40207\n  2. 40220\n  3. 40241");
                    int optionZipcode = scn.nextInt();
                    int zipcode = 0;
                    switch (optionZipcode) {
                        case 1:
                            zipcode = 40207;
                            break;
                        case 2:
                            zipcode = 40220;
                            break;
                        case 3:
                            zipcode = 40241;
                            break;
                        default:
                            break;
                    }

                    Scanner scn2 = new Scanner(System.in);
                    System.out.println("Enter 1, 2 or 3 from cuisine of  1. American  2. Mexican  3. Italian ");
                    int cId = scn2.nextInt();

                    String cuisineName = cuisineRepository.Get(cId).getCuisineName();

                    SearchAllRestaurantLocationCuisine(zipcode, cuisineName);
                    break;
                case 2:
                    System.out.flush();
                    break;
                default:
                    System.out.println("You chose an invalid option.");
                    System.out.flush();
                    break;
            }
            if (menuOption != 2) {
                menuOption = MainMenu();
            }
        }
    }

    static int MainMenu()
    {
        //Display menu on console
        System.out.println("Main Menu");
        System.out.println("1. Get all Restaurants using zip code and cuisine");
        System.out.println("2. Exit");
        System.out.println();
        System.out.println("Enter an option of 1 or 2 to either 1. Search restaurants   OR   2. Exit");

        //capture input
        Scanner scn = new Scanner(System.in);
        int option = scn.nextInt();
        if (!(option == (int)option)) {
            return 3;
        }
        else {
            return (option);
        }
    }

    static void MergeAllRestaurantLocationCuisine() throws IOException {

        ArrayList<AssociatedId> associatedIds = associatedIdRepository.GetAll();

        for (int a = 0; a < associatedIds.size(); a++) {

            //System.out.println("loop count: " + a);
            //get ids of one record
            int aId = associatedIds.get(a).getId();
            int rId = associatedIds.get(a).getRestaurantId();
            int lId = associatedIds.get(a).getLocationId();
            int cId = associatedIds.get(a).getCuisineId();

            //get object containing one records
            Restaurant restaurant = restaurantRepository.Get(rId);
            Location location = locationRepository.Get(lId);
            Cuisine cuisine = cuisineRepository.Get(cId);

            restaurantLocationCuisineRepository.Add(restaurant, location, cuisine);
        }

    }

    static void SearchAllRestaurantLocationCuisine(int z, String cName) {
        ArrayList<RestaurantLocationCuisine> restaurantLocationCuisines = restaurantLocationCuisineRepository.GetAll();
        System.out.println("\n");
        for (int i = 0; i < restaurantLocationCuisines.size(); i++) {
            if ((restaurantLocationCuisines.get(i).getLocation().getZipCode() == z) && (restaurantLocationCuisines.get(i).getCuisine().getCuisineName().equals(cName))) {

                System.out.println(restaurantLocationCuisines.get(i).getId() + " " + restaurantLocationCuisines.get(i).getName() + " " + restaurantLocationCuisines.get(i).getLocation().getId() + " " + restaurantLocationCuisines.get(i).getLocation().getStreet() + " " + restaurantLocationCuisines.get(i).getLocation().getCity() + " " + restaurantLocationCuisines.get(i).getLocation().getState() + " " + restaurantLocationCuisines.get(i).getLocation().getZipCode() + " " + restaurantLocationCuisines.get(i).getCuisine().getId() + " " + restaurantLocationCuisines.get(i).getCuisine().getCuisineName());
            }
        }
        System.out.println("\n");
    }
}




