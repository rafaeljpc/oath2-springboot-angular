package io.github.rafaeljpc.oauth2.study.config

import org.springdoc.core.converters.models.Pageable
import org.springdoc.core.utils.SpringDocUtils
import org.springframework.context.annotation.Configuration

@Configuration
class SpringDocConfig {

    init {
        SpringDocUtils.getConfig()
            .replaceWithClass(org.springframework.data.domain.Pageable::class.java, Pageable::class.java)
            .replaceWithClass(org.springframework.data.domain.PageRequest::class.java, Pageable::class.java)
    }
}