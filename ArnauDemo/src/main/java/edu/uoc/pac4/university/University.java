package edu.uoc.pac4.university;

import java.time.LocalDate;

public class University {
    private String name;
    private String abbreviation;

    private LocalDate foundationDate;
    private String address;
    private String website;

    public University(String name, String abbreviation, LocalDate foundationDate, String address, String website) throws UniversityException {
        setName(name);
        setAbbreviation(abbreviation);
        setFoundationDate(foundationDate);
        setAddress(address);
        setWebsite(website);
    }


    @Override
    public String toString() {
        return name+", "+abbreviation+", "+foundationDate+", "+address+", "+website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws UniversityException {
        if (name == null || name.trim().isEmpty()){
            throw new UniversityException(UniversityException.INVALID_NAME);
        }
        this.name = name.trim();
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) throws UniversityException {
        if(abbreviation == null || !abbreviation.matches("[A-Z]{2,6}")){
            throw new UniversityException(UniversityException.INVALID_ABBREVIATION);
        }
        this.abbreviation = abbreviation;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDate foundationDate) throws UniversityException {
        LocalDate today = LocalDate.now();
        if (foundationDate == null || foundationDate.isAfter(today)) {
            throw new UniversityException(UniversityException.INVALID_FOUNDATION_DATE);
        }
        this.foundationDate = foundationDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address)  throws UniversityException {
        if (address == null){
            throw new UniversityException(UniversityException.INVALID_ADDRESS);
        }
        this.address = address.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) throws UniversityException {
        //?  0 or 1 time
        //+  at least 1 time
        //*  no matter how many times
        if (website == null || !website.matches("(https?://)?[a-z-]+([.][a-z]+)+(/[a-z]+)*")){
            throw new UniversityException(UniversityException.INVALID_WEBSITE);
        }
        this.website = website;
    }
}
