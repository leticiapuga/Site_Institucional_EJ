import { Routes, Route } from "react-router-dom";
import Home from "../pages/home/Home";
import Servicos from "../pages/servicos/Servicos";
import Login from "../pages/login/Login";
import Register from "../pages/register/Register";
import ContactUs from "../pages/contactUs/ContactUs";

function RoutesApp() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/servicos" element={<Servicos />} />
      <Route path="/login" element={<Login />} />
      <Route path="/register" element={<Register />} />
      <Route path="/contactus" element={<ContactUs />} />
    </Routes>
  );
}
export default RoutesApp;
