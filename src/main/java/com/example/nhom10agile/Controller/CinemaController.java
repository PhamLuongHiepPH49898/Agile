package com.example.nhom10agile.Controller;

import com.example.nhom10agile.Entity.*;
import com.example.nhom10agile.Service.*;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cinemas")
public class CinemaController {
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

    @PostMapping("/phong/save")
    public String savePhong(@Valid @ModelAttribute("phong") PhongChieu phong, BindingResult result) {
        if (result.hasErrors()) return "cinemas/phong/form";
        phongChieuService.save(phong);
        return "redirect:/cinemas/phong";
    }

    // ============== QUẢN LÝ SUẤT CHIẾU ==============
    @GetMapping("/suat")
    public String listSuat(Model model) {
        model.addAttribute("suats", suatChieuService.getAllSuat());
        return "cinemas/suat/index";
    }

    @GetMapping("/suat/form")
    public String showSuatForm(Model model) {
        model.addAttribute("suat", new SuatChieu());
        model.addAttribute("phims", phimService.getAllPhim());
        model.addAttribute("phongs", phongChieuService.getAllPhong());
        return "cinemas/suat/form";
    }

    @PostMapping("/suat/save")
    public String saveSuat(@Valid @ModelAttribute("suat") SuatChieu suat, BindingResult result) {
        if (result.hasErrors()) return "cinemas/suat/form";
        suatChieuService.save(suat);
        return "redirect:/cinemas/suat";
    }

    // ============== QUẢN LÝ GHẾ ==============
    @GetMapping("/ghe")
    public String listGhe(Model model) {
        model.addAttribute("ghes", gheService.getAllGhe());
        return "cinemas/ghe/index";
    }

    @GetMapping("/ghe/form")
    public String showGheForm(Model model) {
        model.addAttribute("ghe", new Ghe());
        model.addAttribute("phongs", phongChieuService.getAllPhong());
        return "cinemas/ghe/form";
    }

    @PostMapping("/ghe/save")
    public String saveGhe(@Valid @ModelAttribute("ghe") Ghe ghe, BindingResult result) {
        if (result.hasErrors()) return "cinemas/ghe/form";
        gheService.save(ghe);
        return "redirect:/cinemas/ghe";
    }

    // ============== QUẢN LÝ VÉ ==============
    @GetMapping("/ve")
    public String listVe(Model model) {
        model.addAttribute("ves", veService.getAllVe());
        return "cinemas/ve/index";
    }

    @GetMapping("/ve/form")
    public String showVeForm(Model model) {
        model.addAttribute("ve", new Ve());
        model.addAttribute("suats", suatChieuService.getAllSuat());
        model.addAttribute("ghes", gheService.getAllGhe());
        model.addAttribute("nguoidungs", nguoiDungService.getAllNguoiDung());
        return "cinemas/ve/form";
    }

    @PostMapping("/ve/save")
    public String saveVe(@Valid @ModelAttribute("ve") Ve ve, BindingResult result) {
        if (result.hasErrors()) return "cinemas/ve/form";
        veService.save(ve);
        return "redirect:/cinemas/ve";
    }
}
