package io.github.rafaeljpc.oauth2.study.repository

import io.github.rafaeljpc.oauth2.study.model.UserEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param

interface UserRepository : JpaRepository<UserEntity, Long> {
    fun findByNameLike(@Param("name") name: String?, pageable: Pageable): Page<UserEntity>
}