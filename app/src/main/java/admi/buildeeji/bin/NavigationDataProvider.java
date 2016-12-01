package admi.buildeeji.bin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Admin on 7/17/2016.
 */
public class NavigationDataProvider {
    public List<Parent> mParentList;
    public static final String FORUMS = "Forums";
    public static final String INTERVIEWS = "Interviews";
    public static final String ARTICLES = "Articles";
    public static final String REVIEWS = "Reviews";
    public static final String FEEDBACK = "Feedback";
    public static final String NEW_PROPERTY = "New Property";
    public static final String RESALE_PROPERTY = "Resale Property";
    public static final String RENT_LEASE_PG = "Rent/Lease/Pg";
    public static final String CONSTRUCTION_PROFESSIONALS = "Construction Professionals";
    public static final String CONSTRUCTION_SERVICES = "Construction Services";
    public static final String CONSTRUCTION_MATERIALS = "Construction Materials";
    public static final String HOME = "Home";
    public static final String REAL_ESTATE = "Real Estate";
    public static final String PROPERTY = "Property";
    public static final String BUILD_EXPO = "Build Expo";
    public static final String POST_RESIDENTIAL = "Post Residential";
    public static final String MANAGE_EDIT_LISTING = "Manage Edit Listing";
    public static final String VIEW_RESPONSES = "View Responses";
    public static final String SHORT_LIST = "Short List";
    public static final String RECENT_ACTIVITY = "Recent Activity";


    // RealEstate
    Child forums = new Child("Forums");
    Child interviews = new Child("Interviews");
    Child articles = new Child("Articles");
    Child reviews = new Child("Reviews");
    Child feedback = new Child("Feedback");

    //Property
    Child newProperty = new Child("New Property");
    Child resaleProperty = new Child("Resale Property");
    Child rentLeasePg = new Child("Rent/Lease/Pg");

    //Construction Materials
    Child constructionProfessionals = new Child("Construction Professionals");
    Child constructionServices = new Child("Construction Services");
    Child constructionMaterial = new Child("Construction Materials");

    Parent home = new Parent("Home", null);
    Parent realEstate = new Parent("Real Estate", Arrays.asList(forums, interviews, articles, reviews, feedback));
    Parent property = new Parent("Property", Arrays.asList(newProperty, resaleProperty, rentLeasePg));
    Parent constructionMaterials = new Parent("Construction Materials", Arrays.asList(constructionProfessionals, constructionServices, constructionMaterial));
    Parent buildExpo = new Parent("Build Expo", null);
    Parent postResidential = new Parent("Post Residential", null);
    Parent postCommercial = new Parent("Manage Edit Listing", null);
    Parent viewResponses = new Parent("View Responses", null);
    Parent shortList = new Parent("Short List", null);
    Parent recentActivity = new Parent("Recent Activity", null);

    public List<Parent> getParentList() {
        mParentList = Arrays.asList(home, realEstate, property, constructionMaterials, buildExpo, postResidential, postCommercial, viewResponses, shortList, recentActivity);
        return mParentList;
    }

}
