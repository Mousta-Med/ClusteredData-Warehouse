package org.med.clustereddatawarehouse.controller;

import org.med.clustereddatawarehouse.model.request.FxDealReqDto;
import org.med.clustereddatawarehouse.service.FxDealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "api/v1/fxDeal")
public class FxDealController {

    @Autowired
    private FxDealService fxDealService;

    @PostMapping
    public ResponseEntity<FxDealReqDto> save(@RequestBody FxDealReqDto fxDeal) {
       return ResponseEntity.ok(fxDealService.save(fxDeal));
    }
}
