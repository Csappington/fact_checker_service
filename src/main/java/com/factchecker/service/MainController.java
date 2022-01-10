package com.factchecker.service;

import com.factchecker.service.data.Report;
import com.factchecker.service.data.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/factchecker")
public class MainController {
    @Autowired
    private ReportRepository reportRepository;

    @GetMapping(path="/test")
    public @ResponseBody String testRequest(){
        return "tested";
    }

    @PostMapping(path="/createreport")
    public @ResponseBody String createReport (
            @RequestParam String userName,
            @RequestParam String page,
            @RequestParam String complaintText,
            @RequestParam String supportingLink) {

        Report n = new Report();
        n.setUserName(userName);
        n.setPage(page);
        n.setComplaintText(complaintText);
        n.setSupportingLink(supportingLink);
        reportRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/getreports")
    public @ResponseBody Iterable<Report> getReportsForPage() {
        return reportRepository.findAll();
    }

//    @GetMapping(path="/get-reports")
//    public @ResponseBody Report getReportsForPage(
//            @RequestParam String page) {
//        Optional<Report> report = reportRepository.findById(page);
//        if (report.isPresent()){
//            return report.get();
//        }
//        else {
//            throw new IllegalArgumentException("Could not find any reports for that page");
//        }
//    }
//    TODO: Need to figure out how to set page address as primary key so that pages can be looked up
}
