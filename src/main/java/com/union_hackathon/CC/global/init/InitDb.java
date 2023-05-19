package com.union_hackathon.CC.global.init;

import com.union_hackathon.CC.domain.choice.domain.Choice;
import com.union_hackathon.CC.domain.food.domain.Food;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void dbInit1() {
            Choice choice1 = Choice.builder().one("김치").two("백김치").three("깍두기").four("꼬들빼기").build();
            Choice choice2 = Choice.builder().one("김치").two("백김치").three("깍두기").four("꼬들빼기").build();
            Choice choice3 = Choice.builder().one("김치").two("백김치").three("깍두기").four("꼬들빼기").build();
            Choice choice4 = Choice.builder().one("김치").two("백김치").three("깍두기").four("꼬들빼기").build();
            Choice choice5 = Choice.builder().one("김치").two("백김치").three("깍두기").four("꼬들빼기").build();
            Choice choice6 = Choice.builder().one("김치").two("백김치").three("깍두기").four("꼬들빼기").build();
            Choice choice7 = Choice.builder().one("김치").two("백김치").three("깍두기").four("꼬들빼기").build();
            Choice choice8 = Choice.builder().one("김치").two("백김치").three("깍두기").four("꼬들빼기").build();
            Choice choice9 = Choice.builder().one("김치").two("백김치").three("깍두기").four("꼬들빼기").build();
            Choice choice10 = Choice.builder().one("김치").two("백김치").three("깍두기").four("꼬들빼기").build();
            em.persist(choice1);
            em.persist(choice2);
            em.persist(choice3);
            em.persist(choice4);
            em.persist(choice5);
            em.persist(choice6);
            em.persist(choice7);
            em.persist(choice8);
            em.persist(choice9);
            em.persist(choice10);
            Food food1 = Food.builder().url("aaaa").answer("김치").info("한국인이 즐겨먹는 음식").hint("빨게").question("이 음식의 이름은 무엇입니까?").choice(choice1).build();
            Food food2 = Food.builder().url("aaaa").answer("김치").info("한국인이 즐겨먹는 음식").hint("빨게").question("이 음식의 이름은 무엇입니까?").choice(choice2).build();
            Food food3 = Food.builder().url("aaaa").answer("김치").info("한국인이 즐겨먹는 음식").hint("빨게").question("이 음식의 이름은 무엇입니까?").choice(choice3).build();
            Food food4 = Food.builder().url("aaaa").answer("김치").info("한국인이 즐겨먹는 음식").hint("빨게").question("이 음식의 이름은 무엇입니까?").choice(choice4).build();
            Food food5 = Food.builder().url("aaaa").answer("김치").info("한국인이 즐겨먹는 음식").hint("빨게").question("이 음식의 이름은 무엇입니까?").choice(choice5).build();
            Food food6 = Food.builder().url("aaaa").answer("김치").info("한국인이 즐겨먹는 음식").hint("빨게").question("이 음식의 이름은 무엇입니까?").choice(choice6).build();
            Food food7 = Food.builder().url("aaaa").answer("김치").info("한국인이 즐겨먹는 음식").hint("빨게").question("이 음식의 이름은 무엇입니까?").choice(choice7).build();
            Food food8 = Food.builder().url("aaaa").answer("김치").info("한국인이 즐겨먹는 음식").hint("빨게").question("이 음식의 이름은 무엇입니까?").choice(choice8).build();
            Food food9 = Food.builder().url("aaaa").answer("김치").info("한국인이 즐겨먹는 음식").hint("빨게").question("이 음식의 이름은 무엇입니까?").choice(choice9).build();
            Food food10 = Food.builder().url("aaaa").answer("김치").info("한국인이 즐겨먹는 음식").hint("빨게").question("이 음식의 이름은 무엇입니까?").choice(choice10).build();
            em.persist(food1);
            em.persist(food2);
            em.persist(food3);
            em.persist(food4);
            em.persist(food5);
            em.persist(food6);
            em.persist(food7);
            em.persist(food8);
            em.persist(food9);
            em.persist(food10);
            em.flush();
            em.clear();
        }
    }
}
