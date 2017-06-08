package phasfjo.javacollection;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by paulito on 01.06.2017.
 */
public class JavaCollection2 {

    private List addressList;
    private Set addressSet;
    private Map addressMap;

    public void setAddressList(List addressList) {
        this.addressList = addressList;
    }
    public void setAddressMap(Map addressMap) {
        this.addressMap = addressMap;
    }
    public void setAddressSet(Set addressSet) {
        this.addressSet = addressSet;
    }

    public List getAddressList() {
        System.out.println("List Elements : " + addressList);
        return addressList;
    }

    public Set getAddressSet() {
        System.out.println("Set Elements : " + addressSet);
        return addressSet;
    }

    public Map getAddressMap() {
        System.out.println("Map Elements : " + addressMap);
        return addressMap;
    }
}
