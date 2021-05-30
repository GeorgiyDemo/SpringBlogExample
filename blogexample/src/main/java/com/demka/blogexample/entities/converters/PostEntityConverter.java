package com.demka.blogexample.entities.converters;

import com.demka.blogexample.entities.db.PostDBEntity;
import com.demka.blogexample.entities.db.TagDBEntity;
import com.demka.blogexample.entities.db.UserDBEntity;
import com.demka.blogexample.entities.request.PostRequestEntity;
import com.demka.blogexample.services.TagsService;
import com.demka.blogexample.services.UserService;
import com.github.slugify.Slugify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PostEntityConverter {

    private final UserService userService;
    private final TagsService tagsService;
    private final Slugify slg;

    @Autowired
    public PostEntityConverter(UserService userService, TagsService tagsService) {
        this.userService = userService;
        this.tagsService = tagsService;
        slg = new Slugify();
    }

    /**
     * Конвертер между моделью запроса и моделью СУБД
     *
     * @param requestEntity - запрос
     * @return
     */
    public PostDBEntity convert(PostRequestEntity requestEntity) {
        PostDBEntity entity = new PostDBEntity();
        entity.setSlug(slg.slugify(requestEntity.getTitle()));
        entity.setText(requestEntity.getText());
        entity.setTitle(requestEntity.getTitle());

        Optional<UserDBEntity> authorPostOptional = userService.find(requestEntity.getAuthorPost());
        //Set<Lik>
        if (authorPostOptional.isEmpty())
            return null;
        entity.setAuthorPost(authorPostOptional.get());

        Set<TagDBEntity> tagsSet = new HashSet<>();
        for (long tagId : requestEntity.getTags()) {
            Optional<TagDBEntity> currentTagOptional = tagsService.find(tagId);
            if (currentTagOptional.isEmpty())
                return null;
            tagsSet.add(currentTagOptional.get());
        }

        entity.setDateTime(LocalDateTime.now());
        entity.setTags(tagsSet);
        return entity;
    }
}
