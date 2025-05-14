/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.user;

public class HouseView extends PrivilegeView<House,HouseKey,HouseView,HouseModel,HouseReference,HouseLibrarian> {

    public HouseView(String name, House file) {
        super(name, file);
    }
}
