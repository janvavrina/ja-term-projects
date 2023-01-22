package cz.mendelu.ja.leteckaposta.parcel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/parcels")
public class ParcelController {
    @Autowired
    ParcelService parcelService;

    @GetMapping("/tracking")
    public Map<String,String> getResult(@RequestParam("from") String from, @RequestParam("to") String to){
        var through = parcelService.createTravel(from, to);
        Map<String,String> result = new HashMap<String, String>();
        result.put("from",from);
        result.put("to",to);
        result.put("through:",String.join(",",through));
        result.put("hops:",Integer.toString(through.size()));
        return result;
    }
}
