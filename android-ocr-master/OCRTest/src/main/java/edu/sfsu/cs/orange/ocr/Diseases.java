package edu.sfsu.cs.orange.ocr;

/**
 * Created by cenk.akdeniz on 09.07.2016.
 */
public class Diseases {

    int _id;
    String _title;
    String _ecodes;
    String _language;


    public Diseases(Integer id ,  String title, String ecodes , String language) {
        this._id=id;
        this._title = title;
        this._ecodes=ecodes;
        this._language=language;

    }

    // constructor
    public Diseases(String title, String ecodes , String language) {
        this._title = title;
        this._ecodes=ecodes;
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

    public String getecodes() {
        return _ecodes;
    }

    public void setecodes(String _ecodes) {
        this._ecodes = _ecodes;
    }

    public String get_language() {
        return _language;
    }

    public void set_language(String _language) {
        this._language = _language;
    }
}
