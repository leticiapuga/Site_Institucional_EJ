import { Routes, Route } from "react-router-dom";
import Home from "../pages/home/Home";
import Servicos from "../pages/servicos/Servicos";
import Login from "../pages/login/Login";
import Register from "../pages/register/Register";
import ContactUs from "../pages/contactUs/ContactUs";
import CasosSucesso from "../pages/casosSucesso/CasosSucesso";
import Members from "../pages/members/Members";
import Partnerships from "../pages/partnerships/Partnerships";
import ServicesAdmin from "../pages/admin/ServicesAdmin";
import MembersAdmin from "../pages/admin/MembersAdmin";
import PartnershipsAdmin from "../pages/admin/PartnershipsAdmin";
import SuccessCasesAdmin from "../pages/admin/SuccessCasesAdmin";
import MessagesAdmin from "../pages/admin/MessagesAdmin";

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
      <Route path="/partnerships" element={<Partnerships />} />
      <Route path="/admin/services" element={<ServicesAdmin />} />
      <Route path="/admin/members" element={<MembersAdmin />} />
      <Route path="/admin/partnerships" element={<PartnershipsAdmin />} />
      <Route path="/admin/success-cases" element={<SuccessCasesAdmin />} />
      <Route path="/admin/messages" element={<MessagesAdmin />} />
    </Routes>
  );
}
export default RoutesApp;
