package com.thorrism.materialdesignskeleton.demo.Fragments;

import android.support.v4.app.Fragment;

/**
 * Created by Lucas Crawford on 8/13/2015.
 */
public class TabFragment extends Fragment {
    public static String TYPE_EDIT = "Shake Edit";
    public static String TYPE_DIALOG = "Material Dialog";

    public static TabFragment newInstance(int type) {
        TabFragment newFrag;
        switch (type) {
            case 0:
                newFrag = new MaterialEditFragment();
                break;
            case 1:
                newFrag = new MaterialDialogFragment();
                break;

            default:
                newFrag = new MaterialEditFragment();
        }
        return newFrag;
    }
}
