package com.example.limbusDeckMaker.repository.specification;

import com.example.limbusDeckMaker.domain.Ego;
import com.example.limbusDeckMaker.domain.Sinner;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.stream.Collectors;

public class EgoSpecification {

    public static Specification<Ego> hasSinnerNames(List<String> sinnerNames) {
        return (root, query, cb) -> {
            if (sinnerNames == null || sinnerNames.isEmpty()) {
                return null;
            }
            Join<Ego, Sinner> sinnerJoin = root.join("sinner", JoinType.INNER);
            return sinnerJoin.get("name").in(sinnerNames.stream().map(String::toLowerCase).collect(Collectors.toList()));
        };
    }

        public static Specification<Ego> hasSeasons(List<Integer> seasons) {
            return (Root<Ego> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            if (seasons == null || seasons.isEmpty()) {
                return null;
            }
            return root.get("season").in(seasons);
        };
    }

    public static Specification<Ego> hasGrades(List<String> grades) {
        return (Root<Ego> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            if (grades == null || grades.isEmpty()) {
                return null;
            }
            return root.get("grade").in(grades);
        };
    }
}
