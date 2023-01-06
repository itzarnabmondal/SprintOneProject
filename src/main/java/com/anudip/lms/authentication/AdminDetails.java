package com.anudip.lms.authentication;

import java.util.HashMap;

/**
 * A utility class for storing and retrieving admin details.
 * 
 * This class has a `static` `HashMap` called `admins` that stores the username
 * and password hash
 * of each admin. The `static` block initializes the `admins` map with a set of
 * predefined username
 * and password hash pairs.
 * 
 * The class has three `static` methods: `getPasswordHash`, `hasAdmin`, and
 * `getAdmins`. The
 * `getPasswordHash` method returns the password hash of the admin with the
 * specified username. The
 * `hasAdmin` method returns whether the `admins` map contains an entry with the
 * specified username.
 * The `getAdmins` method returns the `admins` map.
 */
public final class AdminDetails {
        // A map that stores the username and password hash of each admin
        private static final HashMap<String, String> admins = new HashMap<>();

        static {
                // Populate the map with username and password hash pairs
                admins.put("arnab",
                                "76430d2020f5a57eef25768929756f671da42201a3114a50125afd38397f5a31");
                admins.put("rohit",
                                "d7e497a125f72cd95a24c63df12e50e53e7d4b438521526f9dab851a402b19e7");
                admins.put("bidisha",
                                "f41e316ca899dcae59d4f714c394090ca035bd857ea96f18a1ec8e1dc2ea5c36");
                admins.put("pritam",
                                "fe8d95a33338505344bf4a1c379b362d4163375132b978af4825efa1f62ee1df");
                admins.put("tiyasha",
                                "d3c06b823a9a603d042e2d35ff94d8b7f6c70c0fea8b4965c1c579c7f93e9ce9");
                admins.put("puja",
                                "5472857d230774a1f7f833a3979c934975716abd2d55b538027dd2a05b3fd913");
        }

        /**
         * Returns the password hash of the admin with the specified username.
         * 
         * @param username the username of the admin
         * @return the password hash of the admin with the specified username
         */
        static String getPasswordHash(String username) {
                return admins.get(username);
        }

        /**
         * Checks if the given username corresponds to an admin.
         *
         * @param username the username to check
         * @return true if the username is an admin, false otherwise
         */
        public static boolean hasAdmin(String username) {
                return admins.containsKey(username);
        }

        /**
         * Returns the map of admins.
         *
         * @return the map of admins
         */
        public static HashMap<String, String> getAdmins() {
                return admins;
        }

}
