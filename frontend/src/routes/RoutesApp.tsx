import { Routes, Route } from "react-router-dom";
import Home from "../pages/home/Home";
import Servicos from "../pages/servicos/Servicos";
import Login from "../pages/login/Login";
import Register from "../pages/register/Register";
import ContactUs from "../pages/contactUs/ContactUs";
import CasosSucesso from "../pages/casosSucesso/CasosSucesso";
import Members from "../pages/members/Members";

function RoutesApp() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/servicos" element={<Servicos />} />
      <Route path="/login" element={<Login />} />
      <Route path="/register" element={<Register />} />
      <Route path="/contactus" element={<ContactUs />} />
      <Route path="/casosSucesso" element={<CasosSucesso />} />
      <Route path="/members" element={<Members />} />{" "}
      {/* nova rota em inglês */}
    </Routes>
  );
}
export default RoutesApp;
