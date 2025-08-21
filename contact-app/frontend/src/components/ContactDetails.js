import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getContact } from "../api/ContactService";

const ContactDetails = ({ updateContact, updateImage }) => {
  const [contact, setContact] = useState({
    name: "",
    email: "",
    phone: "",
    address: "",
    title: "",
    status: "",
    photoUrl: "",
  });

  const { id } = useParams();

  const fetchContact = async (id) => {
    try {
      const { data } = await getContact(id);
      setContact(data);
      console.log(data);
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    fetchContact(id);
  }, []);

  return <div>ContactDetails</div>;
};

export default ContactDetails;
