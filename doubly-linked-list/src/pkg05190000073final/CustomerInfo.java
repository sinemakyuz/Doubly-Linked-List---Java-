/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg05190000073final;

import java.util.List;

/**
 *
 * @author sinem
 */
public class CustomerInfo {
    private String name;
    private String address;
    private String phoneNumbers;

    CustomerInfo(String name, String address, List phoneList) {
        this.name = name;
        this.address = address;
        setPhoneNumbers(phoneList);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List phoneList) {
        phoneNumbers = phoneList.toString();
    }
    
    @Override
    public String toString() {
        return "Customer's first and last name: " + getName().toUpperCase() + "\nPhone numbers: " + getPhoneNumbers() +
                "\nAddress: " + getAddress().toUpperCase();
}

    public String getSurname() {  //need this method in many places
        String nameSurname = getName();
        String[] nameSurnameSplit = nameSurname.split(" ");
        String surname = nameSurnameSplit[nameSurnameSplit.length - 1];
        return surname;
    }

}
