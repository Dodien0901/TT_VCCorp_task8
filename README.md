Task 8: Xây dựng 1 hệ thống cho một tổ chức hỗ trợ nhân viên của mình đăng nhập vào hệ thống nội bộ. 
-	Các thông tin về nhân viên bao gồm: Mã nhân sự, tên đăng nhập, tên hiển thị, mật khẩu. 
-	Các thông tin về Phòng ban bao gồm: Mã phòng ban, tên phòng ban, ngày thành lập
-	Mỗi phòng ban bao gồm nhiều nhân viên, mỗi nhân viên chỉ thuộc 1 phòng ban
-	Các nhân viên có các Vai trò & Quyền hạn khác nhau. Eg: Leader, Fresher, Internship. Mỗi nhân viên đảm nhiệm 1 vai trò trong tổ chức mà mình được quản lý

Các phương thức đăng nhập cần được hỗ trợ:
-	Đăng nhập bằng thông tin cơ bản: Username + mật khẩu + mã phòng ban (có sử dụng multi factors login(2FA) dạng Time-based One-Time Passwords (TOTP))
-	Đăng nhập sử dụng 3rd-identity provider. Eg: GOOGLE / FACEBOOK / GITHUB...
-	Đăng nhập thông qua cơ chế LDAP (có thể sử dụng embedded LDAP hoặc build 1 LDAP Server)
--> Sau khi đăng nhập thành công hiển thị màn hình chào Welcome tên người dùng 

Yêu cầu: 
1. Xây dựng biểu đồ lớp pha Thiết kế
2. Cài đặt hệ thống hỗ trợ đăng nhập sử dụng công nghệ JAVA 
(YC: Xây dựng dựa trên nền tảng Spring Security)
