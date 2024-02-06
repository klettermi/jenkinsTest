package db.postgrestest.enums;

public enum ServiceResult {
    NOEXIST("존재하지 않는 게시글 입니다.");

    private final String description;

    ServiceResult(String description) {
        this.description = description;
    }
}
