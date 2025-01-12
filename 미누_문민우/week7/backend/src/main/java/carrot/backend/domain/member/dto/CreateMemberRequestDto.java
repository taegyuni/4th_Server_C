package carrot.backend.domain.member.dto;

import carrot.backend.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateMemberRequestDto {

    @NotBlank(message = "닉네임을 입력해주세요.")
    @Size(min = 2, message = "닉네임이 너무 짧습니다.")
    private String nickname;

    @NotBlank(message = "휴대폰 번호를 입력해주세요.")
    @Pattern(regexp = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", message = "휴대폰 번호는 하이픈(-)을 포함해야 합니다.")
    private String phone;

    @NotBlank(message = "위치 정보를 입력해주세요.")
    private String location;

    public Member toEntity() {
        return Member.builder()
                .nickname(this.nickname)
                .phone(this.phone)
                .location(this.location)
                .build();
    }
}
