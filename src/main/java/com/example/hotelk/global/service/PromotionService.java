package com.example.hotelk.global.service;

import com.example.hotelk.global.domain.entity.Promotion;
import com.example.hotelk.global.repository.PromotionRepository;
import com.example.hotelk.global.domain.request.PromotionRequest;
import com.example.hotelk.global.domain.response.PromotionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PromotionService {
    private final PromotionRepository promotionRepository;

    public void insert(PromotionRequest promotionRequest){
        promotionRepository.save(promotionRequest.toEntity());
    }

    public PromotionResponse update(Long promotionId, PromotionRequest promotionRequest){
        Optional<Promotion> byId = promotionRepository.findById(promotionId);
        if(byId.isEmpty()) throw new RuntimeException("없는 프로모션 정보를 수정하려합니다.");
        Promotion promotion = new Promotion(promotionId, promotionRequest.getTitle(), promotionRequest.getDescription(), promotionRequest.getStartDate(), promotionRequest.getEndDate(), null);
        Promotion save = promotionRepository.save(promotion);
        return new PromotionResponse(save);
    }
    public List<PromotionResponse> findAll(){
        List<Promotion> all = promotionRepository.findAll();
        return all.stream().map(p->new PromotionResponse(p)).toList();
    }
    public Optional<Promotion> findByTitle(String title){
        Optional<Promotion> byTitle = promotionRepository.findByTitle(title);
        return  byTitle.map(p->new Promotion());
    }
    public void delete(Long promotionId){
        promotionRepository.deleteById(promotionId);
    }
}
