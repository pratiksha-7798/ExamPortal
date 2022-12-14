package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.QuestionsEntity;

public interface QuestionRepository extends JpaRepository<QuestionsEntity, Integer>
{
   
}
