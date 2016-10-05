package edu.sfsu.cs.orange.ocr;

/**
 * Created by cenk.akdeniz on 06.04.2016.
 */
public class Certificates {
    // private variables
    int _id;
    String _title;
    String _application_areas;
    String _deseases;
    String _banned_countries;
    String _condition;
    String _language;

    // Empty constructor
    public Certificates() {

    }

    // constructor
    public Certificates(int keyId, String title , String applicationAreas , String deseases, String bannedCountries, String condition , String language) {
        this._id = keyId;
        this._title = title;
        this._application_areas = applicationAreas;
        this._deseases=deseases;
        this._banned_countries= bannedCountries;
        this._condition=condition;
        this._language=language;
    }

    // constructor
    public Certificates(String title, String applicationAreas, String deseases, String bannedCountries, String condition, String language) {
        this._title = title;
        this._application_areas = applicationAreas;
        this._deseases=deseases;
        this._banned_countries=bannedCountries;
        this._condition=condition;
        this._language=language;
    }

    // getting ID
    public int getID() {
        return this._id;
    }

    // setting id
    public void setID(int keyId) {
        this._id = keyId;
    }

    // getting title
    public String gettitle() {
        return this._title;
    }

    // setting title
    public void settitle(String title) {
        this._title = title;
    }

    // getting phone number
    public String getapplication_areas() {
        return this._application_areas;
    }

    // setting phone number
    public void setapplication_areas(String application_areas) {
        this._application_areas = application_areas;
    }

    public String getdeseases() {
        return _deseases;
    }

    public void setdeseases(String _deseases) {
        this._deseases = _deseases;
    }

    public String get_banned_countries() {
        return _banned_countries;
    }

    public void set_banned_countries(String _banned_countries) {
        this._banned_countries = _banned_countries;
    }

    public String get_condition() {
        return _condition;
    }

    public void set_condition(String _condition) {
        this._condition = _condition;
    }

    public String get_language() {
        return _language;
    }

    public void set_language(String _language) {
        this._language = _language;
    }
}
