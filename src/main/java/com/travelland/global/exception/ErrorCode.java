package com.travelland.global.exception;

import com.travelland.domain.plan.VotePaper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    // 400 BAD_REQUEST: 잘못된 요청
    INVALID_REFRESH_TOKEN(BAD_REQUEST, "리프레시 토큰이 유효하지 않습니다"),
    MISMATCH_REFRESH_TOKEN(BAD_REQUEST, "리프레시 토큰의 유저 정보가 일치하지 않습니다"),
    WRONG_MULTIPARTFILE(BAD_REQUEST, "Multipartfile에 문제가 있습니다"),
    WRONG_USERINFO(BAD_REQUEST,"유저 정보를 다시 확인해주세요"),

    // 401 UNAUTHORIZED: 인증되지 않은 사용자
    INVALID_AUTH_TOKEN(UNAUTHORIZED, "권한 정보가 없는 토큰입니다"),
    UNAUTHORIZED_MEMBER(UNAUTHORIZED, "존재하지 않는 회원입니다."),

    // 403 FORBIDDEN: 권한이 없는 접근
    POST_UPDATE_NOT_PERMISSION(FORBIDDEN, "해당 게시물을 수정할 권한이 없습니다."),
    POST_DELETE_NOT_PERMISSION(FORBIDDEN, "해당 게시물을 삭제할 권한이 없습니다."),
    POST_COMMENT_DELETE_NOT_PERMISSION(FORBIDDEN, "해당 댓글을 삭제할 권한이 없습니다."),
    PLAN_VOTE_IS_CLOSED(FORBIDDEN, "해당 투표장은 기간만료로 닫혀 투표 권한이 없습니다."),
    RE_VOTE_NOT_ENOUGH_TIME(FORBIDDEN, "재투표는 " + VotePaper.RE_VOTE_ABLE_TIME + "초 후에 가능합니다."),

    // 404 NOT_FOUND: 잘못된 리소스 접근
    REFRESH_TOKEN_NOT_FOUND(NOT_FOUND, "로그아웃 된 사용자입니다"),
    MEMBER_NOT_FOUND(NOT_FOUND, "해당 회원 정보를 찾을 수 없습니다."),
    POST_NOT_FOUND(NOT_FOUND, "해당 게시글을 찾을 수 없습니다."),
    POST_IMAGE_NOT_FOUND(NOT_FOUND, "해당 게시글의 이미지를 찾을 수 없습니다."),
    POST_SCRAP_NOT_FOUND(NOT_FOUND, "해당 게시글은 스크랩되어 있지 않습니다."),
    POST_LIKE_NOT_FOUND(NOT_FOUND, "해당 게시글은 좋아요가 되어 있지 않습니다."),
    POST_COMMENT_NOT_FOUND(NOT_FOUND, "해당 댓글을 찾을 수 없습니다."),
    PLAN_NOT_FOUND(NOT_FOUND, "해당 여행 플랜을 찾을 수 없습니다."),
    DAY_PLAN_NOT_FOUND(NOT_FOUND, "해당 일일 플랜을 찾을 수 없습니다."),
    UNIT_PLAN_NOT_FOUND(NOT_FOUND, "해당 단위 플랜을 찾을 수 없습니다."),
    PLAN_COMMENT_NOT_FOUND(NOT_FOUND, "해당 댓글을 찾을 수 없습니다."),
    PLAN_VOTE_NOT_FOUND(NOT_FOUND, "해당 투표장을 찾을 수 없습니다."),
    VOTE_PAPER_NOT_FOUND(NOT_FOUND, "해당 투표지를 찾을 수 없습니다."),
    USER_NOT_FOUND(NOT_FOUND, "해당 사용자를 찾을 수 없습니다."),

    // 409 CONFLICT: 중복된 리소스 (요청이 현재 서버 상태와 충돌될 때)
    DUPLICATE_EMAIL(CONFLICT, "이미 존재하는 이메일입니다."),
    DUPLICATE_NICKNAME(CONFLICT, "이미 존재하는 닉네임입니다."),
    DUPLICATE_SCRAP(CONFLICT, "이미 스크랩을 하였습니다."),
    DUPLICATE_LIKE(CONFLICT, "이미 좋아요를 누르셨습니다."),

    // 500 INTERNAL SERVER ERROR
    SERVER_ERROR(INTERNAL_SERVER_ERROR, "내부 서버 에러입니다.");

    private final HttpStatus httpStatus;
    private final String message;

}
