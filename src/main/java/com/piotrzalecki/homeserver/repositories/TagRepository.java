package com.piotrzalecki.homeserver.repositories;

import com.piotrzalecki.homeserver.domain.Tag;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> {
}
