//package me.example.toDoManage.security;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//import me.example.toDoManage.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//// Lọc request để lấy jwt từ header
//@Slf4j
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private JwtTokenProvider jwtTokenProvider;
//
//    @Autowired
//    private UserService userService;
//
//    // Lọc request để lấy jwt từ header
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException{
//        try {
//            // Lấy jwt từ request
//            String jwt = getJwtFromRequest(request);
//
//            // Validate jwt
//            if (StringUtils.hasText(jwt) && jwtTokenProvider.validateToken(jwt)) {
//                // Lấy id từ chuỗi jwt
//                Long userid = jwtTokenProvider.getUserIdFromJwt(jwt);
//                // Lấy thông tin người dùng từ id
//                UserDetails userDetails = userService.loadUserById(userid);
//                if (userDetails != null) {
//                    // nếu hợp lệ set thông tin cho Seturity Context
//                    UsernamePasswordAuthenticationToken
//                            authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//                    // Set thông tin authentication vào Security Context
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                }
//            }
//        } catch (Exception ex) {
//            log.error("failed on set user authentication", ex);
//        }
//
//        // Cho phép request đi tiếp sang Filter tiếp theo
//        filterChain.doFilter(request, response);
//    }
//
//
//    private String getJwtFromRequest(HttpServletRequest request) {
//        String bearerToken = request.getHeader("Authorization");
//        // Kiểm tra header Authorization có chứa thông tin jwt không
//        if (bearerToken != null && bearerToken.startsWith("Bearer")) {
//            return bearerToken.substring(7);
//        }
//        return null;
//    }
//
//
//}
