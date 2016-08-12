package admi.buildeeji.bin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Admin on 7/17/2016.
 */
public class NavigationDataProvider {

    public static LinkedHashMap<String, List<String>> getNavigationData() {

        List<String> navigationDataHedder = new ArrayList<String>();
        LinkedHashMap<String, List<String>> navigationDataChild = new LinkedHashMap<String, List<String>>();

        //Adding Parent Data
        navigationDataHedder.add("HOME");
        navigationDataHedder.add("REAL ESTATE");
        navigationDataHedder.add("PROPERTY");
        navigationDataHedder.add("CONSTRUCTION MATERIALS");
        navigationDataHedder.add("BUILD EXPO");
        navigationDataHedder.add("POST RESIDENTIAL");
        navigationDataHedder.add("POST COMMERCIAL");
        navigationDataHedder.add("MANAGE EDIT LISTING");
        navigationDataHedder.add("VIEW RESPONSES");
        navigationDataHedder.add("SHORT LIST");
        navigationDataHedder.add("RECENT ACTIVITY");

        //Adding Child data

        List<String> home = new ArrayList<String>();

        List<String> realEstate = new ArrayList<String>();
        realEstate.add("FORUMS");
        realEstate.add("INTERVIEWS");
        realEstate.add("ARTICLES");
        realEstate.add("REVIEWS");
        realEstate.add("FEEDBACK");

        List<String> property = new ArrayList<String>();
        property.add("NEW PROPERTY");
        property.add("RESALE PROPERTY");
        property.add("RENT/LEASE/PG");

        List<String> constructionMaterials = new ArrayList<String>();
        constructionMaterials.add("CONSTRUCTION PROFESSIONALS");
        constructionMaterials.add("CONSTRUCTION SERVICES");
        constructionMaterials.add("CONSTRUCTION MATERIALS");

        List<String> buildExpo = new ArrayList<String>();

        List<String> postResidential = new ArrayList<String>();

        List<String> postCommercial = new ArrayList<String>();

        List<String> manageEditListing = new ArrayList<String>();

        List<String> viewResponses = new ArrayList<String>();

        List<String> shortLists = new ArrayList<String>();

        List<String> recentActivity = new ArrayList<String>();

        navigationDataChild.put(navigationDataHedder.get(0), home);
        navigationDataChild.put(navigationDataHedder.get(1), realEstate);
        navigationDataChild.put(navigationDataHedder.get(2), property);
        navigationDataChild.put(navigationDataHedder.get(3), constructionMaterials);
        navigationDataChild.put(navigationDataHedder.get(4), buildExpo);
        navigationDataChild.put(navigationDataHedder.get(5), postResidential);
        navigationDataChild.put(navigationDataHedder.get(6), postCommercial);
        navigationDataChild.put(navigationDataHedder.get(7), manageEditListing);
        navigationDataChild.put(navigationDataHedder.get(8), viewResponses);
        navigationDataChild.put(navigationDataHedder.get(9), shortLists);
        navigationDataChild.put(navigationDataHedder.get(10), recentActivity);

        return navigationDataChild;
    }
}
