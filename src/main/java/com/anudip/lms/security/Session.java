package com.anudip.lms.security;

/**
 * A class for storing session-related information.
 * 
 * This class has three static fields: `isLoggedIn`, `UserAgent`, and
 * `sessionId`. The `isLoggedIn`
 * field is a boolean that indicates whether the user is logged in. The
 * `UserAgent` field is a string
 * that stores the user agent of the user's browser. The `sessionId` field is a
 * string that stores the
 * session id of the user's session.
 * 
 * The class has four static getter and setter methods for each of the fields.
 * These methods allow
 * other classes to access and modify the session-related information.
 * 
 * @since v1.0
 */
public final class Session {
    private static boolean isLoggedIn = false; // a boolean that indicates whether the user is logged in
    private static String UserAgent; // a string that stores the user agent of the user's browser
    private static String sessionId; // a string that stores the session id of the user's session

    /**
     * Returns whether the user is logged in.
     * 
     * @return `true` if the user is logged in, `false` otherwise
     */
    public static boolean isLoggedIn() {
        return isLoggedIn;
    }

    /**
     * Sets the value of the `isLoggedIn` field.
     * 
     * @param isLoggedIn the value to set for the `isLoggedIn` field
     */
    public static void setLoggedIn(boolean isLoggedIn) {
        Session.isLoggedIn = isLoggedIn;
    }

    /**
     * Returns the user agent of the user's browser.
     * 
     * @return the user agent of the user's browser
     */
    public static String getUserAgent() {
        return UserAgent;
    }

    /**
     * Sets the value of the `UserAgent` field.
     * 
     * @param userAgent the value to set for the `UserAgent` field
     */
    public static void setUserAgent(String userAgent) {
        UserAgent = userAgent;
    }

    /**
     * Returns the session id of the user's session.
     * 
     * @return the session id of the user's session
     */
    public static String getSessionId() {
        return sessionId;
    }

    /**
     * Sets the value of the `sessionId` field.
     * 
     * @param sessionId the value to set for the `sessionId` field
     */
    public static void setSessionId(String sessionId) {
        Session.sessionId = sessionId;
    }
}
