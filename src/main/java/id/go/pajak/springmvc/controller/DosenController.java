package id.go.pajak.springmvc.controller;

import id.go.pajak.springmvc.bean.Base;
import id.go.pajak.springmvc.bean.Dosen;
import id.go.pajak.springmvc.service.DosenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author edwin < edwinkun at gmail dot com >
 */
@Controller
public class DosenController {

    @Autowired
    private DosenService dosenService;

    @RequestMapping(value = "/dosen", method = RequestMethod.GET)
    public String index() {
        return "dosen";
    }

    @RequestMapping(value = "/dosen/list", method = RequestMethod.POST)
    public @ResponseBody
    Base index(@RequestParam Integer sEcho,
            @RequestParam Integer iDisplayStart,
            @RequestParam Integer iDisplayLength,
            @RequestParam String sSortDir_0,
            @RequestParam String sSearch) {
        List<String[]> strings = dosenService.select(iDisplayStart, iDisplayLength, sSortDir_0, sSearch);

        Base base = new Base();
        base.setsEcho(sEcho);

        Long size = dosenService.getSize(sSearch);
        base.setiTotalDisplayRecords(size);
        base.setiTotalRecords(size);
        base.setsEcho(sEcho);
        base.setAaData(strings);

        return base;
    }
    
    @RequestMapping(value ="/dosen/detail/{id}", method = RequestMethod.GET)
    public String view(ModelMap modelMap, @PathVariable String id) {
        modelMap.put("dosen", dosenService.select(id));
        return "dosenEdit";
    }
    
    @RequestMapping(value ="/dosen/new", method = RequestMethod.GET)
    public String add() {
        return "dosenEdit";
    }
    
    @RequestMapping(value ="/dosen/save", method = RequestMethod.POST)
    public String save(ModelMap modelMap, @ModelAttribute Dosen dosen) {
        try {
            dosenService.saveOrUpdate(dosen);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/dosen";
    }
    
}
