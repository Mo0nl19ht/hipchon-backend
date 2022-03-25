package gritbus.hipchonbackend.Api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gritbus.hipchonbackend.Service.MyplaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/myplace")
public class MyplaceController {
	private final MyplaceService myplaceService;

	@Operation(summary = "마이플레이스에 저장 API", description = "중복시 null 반환\n저장 성공시 myplaceId 반환(프론트에서 당장은 사용할 일 없음)")
	@PostMapping("/{user_id}/{place_id}")
	public Result addMyplace(@PathVariable("user_id") Long userId, @PathVariable("place_id") Long placeId) {
		return new Result(myplaceService.add(userId, placeId));
	}

	@Operation(summary = "마이플레이스 조회 API", description = "")
	@GetMapping("/{user_id}")
	public Result findAllMyplace(@Parameter(required = true, example = "1") @PathVariable("user_id") Long userId) {
		return new Result(myplaceService.findAllMyplace(userId));
	}

	@Data
	@AllArgsConstructor
	static class Result<T> {
		private T data;
	}
}
