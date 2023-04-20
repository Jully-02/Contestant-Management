package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Province implements Serializable{
	private int provinceCode;
	private String provinceName;

	public Province(int provinceCode, String provinceName) {
		this.provinceCode = provinceCode;
		this.provinceName = provinceName;
	}

	public int getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(int provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Province other = (Province) obj;
		return provinceCode == other.provinceCode && Objects.equals(provinceName, other.provinceName);
	}

	public static ArrayList<Province> getListProvince() {
		String[] listProvinceName = { "Hà Giang", "Cao Bằng", "Lào Cai", "Sơn La", "Lai Châu", "Bắc Kạn", "Lạng Sơn",
				"Tuyên Quang", "Yên Bái", "Thái Nguyên", "Điện Biên", "Phú Thọ", "Vĩnh Phúc", "Bắc Giang", "Bắc Ninh",
				"Hà Nội", "Quảng Ninh", "Hải Dương", "Hải Phòng", "Hòa Bình", "Hưng Yên", "Hà Nam", "Thái Bình",
				"Nam Định", "Ninh Bình", "Thanh Hóa", "Nghệ An", "Hà Tĩnh", "Quảng Bình", "Quảng Trị", "Thừa Thiên Huế",
				"Đà Nẵng", "Quảng Nam", "Quảng Ngãi", "Kon Tum", "Gia Lai", "Bình Định", "Phú Yên", "Đắk Lắk",
				"Khánh Hòa", "Đắk Nông", "Lâm Đồng", "Ninh Thuận", "Bình Phước", "Tây Ninh", "Bình Dương", "Đồng Nai",
				"Bình Thuận", "Thành phố Hồ Chí Minh", "Long An", "Bà Rịa – Vũng Tàu", "Đồng Tháp", "An Giang",
				"Tiền Giang", "Vĩnh Long", "Bến Tre", "Cần Thơ", "Kiên Giang", "Trà Vinh", "Hậu Giang", "Sóc Trăng",
				"Bạc Liêu", "Cà Mau"};
		ArrayList<Province> listProvince = new ArrayList<Province>();
		int i = 1;
		for (String province : listProvinceName) {
			Province x = new Province (i, province);
			listProvince.add(x);
			i++;
		}
		return listProvince;
	}

	public static Province getProvinceByCode(int homeTown) {
		return Province.getListProvince().get(homeTown);
	}

	public static Province getProvinceByName(String provinceName) {
		ArrayList<Province> listProvince = Province.getListProvince();
		for (Province province : listProvince) {
			if (province.getProvinceName().equals(provinceName)) {
				return province;
			}
		}
		return null;
	}

}
