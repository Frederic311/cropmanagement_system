package com.group2.cropmanagement.controller;

import com.group2.cropmanagement.service.HarvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/harvest")
public class HarvestController {
    @Autowired
    private HarvestService harvestService;
}
