package cz.mendelu.ja.leteckaposta.parcel;

import cz.mendelu.ja.leteckaposta.country.Country;
import cz.mendelu.ja.leteckaposta.country.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ParcelService {
    @Autowired
    private ParcelTravel parcelTravel;

    @Autowired
    private CountryRepository countryRepository;


    public Map getMap(){
        List<Country> countries = (List<Country>) countryRepository.findAll();
        List<String> countryNames = countries
                .stream()
                .map(Country::getCca3)
                .toList();
        HashMap<String, ArrayList<String>> countryMap = new HashMap<>();

        for (String country : countryNames) {
            List<Country> borderCountries = (List<Country>) countryRepository.getCountriesByBorders(country);
            List<String> borderCountryNames = borderCountries
                    .stream()
                    .map(Country::getCca3)
                    .toList();
            countryMap.put(country, new ArrayList<>(borderCountryNames));
        }
        return countryMap;
    }

    public List<String> createTravel(String from, String to){
        return parcelTravel.traveler(from,to,getMap());
    }
}
