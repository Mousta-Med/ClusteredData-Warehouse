package org.med.clustereddatawarehouse.service.impl;

import org.med.clustereddatawarehouse.exception.ResourceAlreadyExistException;
import org.med.clustereddatawarehouse.model.entity.FxDeal;
import org.med.clustereddatawarehouse.model.request.FxDealReqDto;
import org.med.clustereddatawarehouse.repository.FxDealRepository;
import org.med.clustereddatawarehouse.service.FxDealService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FxDealServiceImpl implements FxDealService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FxDealRepository fxDealRepository;


    @Override
    public FxDealReqDto save(FxDealReqDto request) {
        if (!fxDealRepository.existsById(request.getId())) {
            return modelMapper.map(fxDealRepository.save(modelMapper.map(request, FxDeal.class)), FxDealReqDto.class);
        } else {
            throw new ResourceAlreadyExistException("Deal Already Exist with this id: " + request.getId());
        }
    }
}
