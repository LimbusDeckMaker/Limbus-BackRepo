package com.example.limbusDeckMaker.repository.specification;

import com.example.limbusDeckMaker.domain.Ego;
import com.example.limbusDeckMaker.domain.Identity;
import org.springframework.data.jpa.domain.Specification;

public class EgoSpecification {

    public static Specification<Ego> hasSinnerId(Long sinnerId) {
        return (root, query, cb) -> {
            if (sinnerId == null) return null;
            return cb.equal(root.get("sinner").get("id"), sinnerId);
        };
    }

    public static Specification<Ego> hasSeason(Integer season) {
        return (root, query, cb) -> {
            if (season == null) return null;
            return cb.equal(root.get("season"), season);
        };
    }

    public static Specification<Ego> hasGrade(String grade) {
        return (root, query, cb) -> {
            if (grade == null)
                return null;
            return cb.equal(root.get("grade"), grade);
        };
    }
}
