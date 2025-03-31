package com.example.nhom10agile.Controller;

import com.example.nhom10agile.Entity.*;
import com.example.nhom10agile.Service.*;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/cinemas")
public class CinemaController {
    private static final Logger logger = LoggerFactory.getLogger(SuatChieuService.class);
    private final GheService gheService;
    private final NguoiDungService nguoiDungService;
    private final PhimService phimService;
    private final PhongChieuService phongChieuService;
    private final RapPhimService rapPhimService;
    private final SuatChieuService suatChieuService;
    private final VeService veService;

    public CinemaController(GheService gheService, NguoiDungService nguoiDungService, PhimService phimService, PhongChieuService phongChieuService, RapPhimService rapPhimService, SuatChieuService suatChieuService, VeService veService) {
        this.gheService = gheService;
        this.nguoiDungService = nguoiDungService;
        this.phimService = phimService;
        this.phongChieuService = phongChieuService;
        this.rapPhimService = rapPhimService;
        this.suatChieuService = suatChieuService;
        this.veService = veService;
    }
    @GetMapping("/")
    public String showMainPage() {
        return "Main"; // Trả về file main.html
    }

    // ============== QUẢN LÝ PHIM ==============
    @GetMapping("/phim")
    public String phim(Model model) {
        model.addAttribute("phimList", phimService.getAllPhim());
        return "cinemas/index";  // Trỏ tới templates/cinemas/index.html
    }

    @GetMapping("/phim/form")
    public String phimForm(Model model) {
        model.addAttribute("phim", new Phim());
        return "cinemas/form";  // Trỏ tới templates/cinemas/form.html
    }

    @PostMapping("/phim/save")
    public String savePhim(@ModelAttribute("phim") Phim phim) {
        phimService.save(phim);
        return "redirect:/cinemas/phim";
    }

    @GetMapping("/phim/edit/{id}")
    public String phimEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("phim", phimService.getById(id));
        return "cinemas/edit";  // Trỏ tới templates/cinemas/edit.html
    }

    @PostMapping("/phim/update")
    public String updatePhim(@ModelAttribute("phim") Phim phim) {
        phimService.save(phim);
        return "redirect:/cinemas/phim";
    }

    @GetMapping("/phim/delete/{id}")
    public String deletePhim(@PathVariable("id") Long id) {
        phimService.deleteById(id);
        return "redirect:/cinemas/phim";
    }

    // ============== QUẢN LÝ RẠP PHIM ==============
    @GetMapping("/rap")
    public String rap(Model model) {
        model.addAttribute("rapPhims", rapPhimService.getAllRap());
        return "cinemas/rap/index";
    }

    @GetMapping("/rap/form")
    public String showRapForm(Model model) {
        model.addAttribute("rapPhim", new RapPhim());
        return "cinemas/rap/form";
    }

    @PostMapping("/rap/save")
    public String saveRap(@ModelAttribute("rapPhim") RapPhim rapPhim) {
        rapPhimService.save(rapPhim);
        return "redirect:/cinemas/rap";
    }

    @GetMapping("/rap/edit/{id}")
    public String editRap(@PathVariable("id") Long id, Model model) {
        model.addAttribute("rapPhim", rapPhimService.getById(id));
        return "cinemas/rap/edit";
    }
    @PostMapping("/rap/edit")
    public String editRap(@Valid @ModelAttribute("rapPhim") RapPhim rapPhim, BindingResult result) {
        if (result.hasErrors()) return "cinemas/rap/edit";
        rapPhimService.save(rapPhim);
        return "redirect:/cinemas/rap";
    }


    @GetMapping("/rap/delete/{id}")
    public String deleteRap(@PathVariable("id") Long id) {
        rapPhimService.deleteById(id);
        return "redirect:/cinemas/rap";
    }

    // ============== QUẢN LÝ PHÒNG CHIẾU ==============
    @GetMapping("/phong")
    public String listPhong(Model model) {
        model.addAttribute("phongs", phongChieuService.getAllPhong());
        return "cinemas/phong/index";
    }

    @GetMapping("/phong/form")
    public String showPhongForm(Model model) {
        model.addAttribute("phong", new PhongChieu());
        model.addAttribute("raps", rapPhimService.getAllRap());
        return "cinemas/phong/form";
    }
    @GetMapping("/phong/delete/{id}")
    public String deletePhong(@PathVariable("id") Long id) {
        phongChieuService.deleteById(id);
        return "redirect:/cinemas/phong";
    }

    @PostMapping("/phong/save")
    public String savePhong(@Valid @ModelAttribute("phong") PhongChieu phong, BindingResult result) {
        if (result.hasErrors()) return "cinemas/phong/form";
        phongChieuService.save(phong);
        return "redirect:/cinemas/phong";
    }

    // ============== QUẢN LÝ SUẤT CHIẾU ==============
    @GetMapping("/suat")
    public String listSuat(Model model) {
        List<SuatChieu> suats = suatChieuService.getAllSuat();
        model.addAttribute("suatList", suats);
        return "cinemas/suat/index"; // Trả về trang index.html trong thư mục cinemas/suat
    }

    @GetMapping("/suat/form")
    public String showSuatForm(Model model) {
        model.addAttribute("suat", new SuatChieu());
        model.addAttribute("phims", phimService.getAllPhim());
        model.addAttribute("phongs", phongChieuService.getAllPhong());
        return "cinemas/suat/form";
    }

    @PostMapping("/suat/form")
    public String saveSuat(@Valid @ModelAttribute("suat") SuatChieu suat, BindingResult result) {
        if (result.hasErrors()) return "cinemas/suat/form";
        suatChieuService.save(suat);
        return "redirect:/cinemas/suat";
    }
    @GetMapping("/suat/delete/{id}")
    public String deleteSuat(@PathVariable("id") Long id) {
        suatChieuService.deleteById(id);
        return "redirect:/cinemas/suat";
    }
    @GetMapping("/suat/edit/{id}")
    public String editSuat(@PathVariable("id") Long id, Model model) {
        model.addAttribute("suat", suatChieuService.getById(id)); // Sửa lỗi lấy sai đối tượng
        model.addAttribute("phims", phimService.getAllPhim());
        model.addAttribute("phongs", phongChieuService.getAllPhong());
        return "cinemas/suat/edit";
    }
    @PostMapping("/suat/edit")
    public String editSuat(@Valid @ModelAttribute("suat") SuatChieu suat, BindingResult result) {
        if (result.hasErrors()) return "cinemas/suat/form";
        suatChieuService.save(suat);
        return "redirect:/cinemas/suat";
    }

    // Cập nhật suất chiếu (BỎ QUA VALIDATE)
    @PostMapping("/edit")
    public String updateSuat(@ModelAttribute("suat") SuatChieu suat, Model model) {
        suatChieuService.save(suat);
        return "redirect:/cinemas/suat";
    }

    // ============== QUẢN LÝ GHẾ ==============
    @PostMapping("/dat/{id}")
    public ResponseEntity<Map<String, Object>> datGhe(@PathVariable("id") Long id) {
        boolean success = gheService.datGhe(id);  // Lógica đặt ghế
        Map<String, Object> response = new HashMap<>();
        response.put("success", success);
        response.put("message", success ? "Ghế đã được đặt thành công" : "Lỗi xảy ra");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/huy/{id}")
    public ResponseEntity<Map<String, Object>> huyGhe(@PathVariable("id") Long id) {
        boolean success = gheService.huyGhe(id);  // Lógica hủy ghế
        Map<String, Object> response = new HashMap<>();
        response.put("success", success);
        response.put("message", success ? "Ghế đã được hủy" : "Lỗi xảy ra");
        return ResponseEntity.ok(response);
    }
    //    @GetMapping("/cinemas/ghe")
//    public String getGheList(Model model) {
//        List<Ghe> gheList = gheService.getAllGhe();
//        model.addAttribute("ghes", gheList);
//        return "cinemas/ghe/index";
//    }
    @GetMapping("/ghe")
    public String listGhe(Model model) {

        model.addAttribute("TrangThaiGhe", Ghe.TrangThaiGhe.values());
        List<Ghe> gheList = gheService.getAllGhe();
        model.addAttribute("ghes", gheList);
        // Các model khác
        return "cinemas/ghe/index";
    }
    @GetMapping("/ghe/delete/{id}")
    public String deleteGhe(@PathVariable("id") Long id) {
        gheService.delete(id);
        return "redirect:/cinemas/ghe";
    }

    @GetMapping("/ghe/form")
    public String showGheForm(Model model) {
        model.addAttribute("ghe", new Ghe());
        model.addAttribute("phongs", phongChieuService.getAllPhong());
        return "cinemas/ghe/form";
    }

    @PostMapping("/ghe/save")
    public String saveGhe( @ModelAttribute("ghe") Ghe ghe) {

        gheService.save(ghe);
        return "redirect:/cinemas/ghe";
    }
    @GetMapping("/ghe/booking")
    public String bookingGhe(Model model) {
        model.addAttribute("ghes", gheService.getAllGhe());
        return "cinemas/ghe/booking";
    }

    // ============== QUẢN LÝ VÉ ==============
    @GetMapping("/ve")
    public String listVe(Model model) {
        model.addAttribute("ves", veService.getAllVe());
        return "cinemas/ve/index";
    }

    @GetMapping("/ve/{id}")
    public String getVeForm(@PathVariable Long id, Model model) {
        Ve ve = veService.findById(id); // Lấy dữ liệu từ database
        if (ve.getSuatChieu() == null || ve.getSuatChieu().getPhim() == null) {
            System.out.println("Dữ liệu suất chiếu hoặc phim bị null!");
        }
        model.addAttribute("ve", ve);
        return "cinemas/ve/form";
    }
    @GetMapping("/ve/form")
    public String showVeForm(Model model) {
        List<Ve> ves = veService.getAllVe();
        model.addAttribute("ves", ves);
        model.addAttribute("suats", suatChieuService.getAllSuat());
        model.addAttribute("ghes", gheService.getAllGhe());
        model.addAttribute("nguoidungs", nguoiDungService.getAllNguoiDung());
        return "cinemas/ve/form";
    }

    @PostMapping("/ve/save")
    public String saveVe(@Valid @ModelAttribute("ve") Ve ve, BindingResult result,
                         Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("suats", suatChieuService.getAllSuat());
            model.addAttribute("ghes", gheService.getAllGhe());
            model.addAttribute("nguoidungs", nguoiDungService.getAllNguoiDung());
            return "cinemas/ve/form";
        }

        if (ve.getGhe() == null || ve.getGhe().getId() == null) {
            model.addAttribute("errorMessage", "Vui lòng chọn ghế!");
            model.addAttribute("suats", suatChieuService.getAllSuat());
            model.addAttribute("ghes", gheService.getAllGhe());
            model.addAttribute("nguoidungs", nguoiDungService.getAllNguoiDung());
            return "cinemas/ve/form";
        }

        // Lưu vé vào database
        veService.save(ve);

        // Thêm thông báo thành công
        redirectAttributes.addFlashAttribute("successMessage", "Đặt vé thành công!");

        return "redirect:/cinemas/ve";
    }

}