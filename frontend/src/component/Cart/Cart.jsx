import React from "react";
import CartItem from "./CartItem";
import {
  Box,
  Button,
  Card,
  Divider,
  Grid,
  Modal,
  TextField,
} from "@mui/material";
import AddressCart from "./AddressCart";
import AddLocationIcon from "@mui/icons-material/AddLocation";
import { ErrorMessage, Field, Form, Formik } from "formik";
import { useDispatch, useSelector } from "react-redux";
import { createOrder } from "../State/Order/Action";
// import * as Yup from "yup"

export const style = {
  position: "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: 400,
  bgcolor: "background.paper",
  outline: "none",
  boxShadow: 24,
  p: 4,
};

const initialValues = {
  streetAddress: "",
  state: "",
  pincode: "",
  city: "",
};

//   const validationSchema= Yup.object.shape({
//     streetAddress:Yup.string().required("Street address is required"),
//     state:Yup.string().required("State is required"),
//     pincode:Yup.required("Pincode is required"),
//     city:Yup.string().required("City is required")
//   })

// const items = [1, 1]; // dummy data

const Cart = () => {
  const createOrderUsingSelectedAddress = () => {};
  const handleOpenAddessModal = () => setOpen(true);
  const [open, setOpen] = React.useState(false);
  const handleClose = () => setOpen(false);
  const { cart, auth } = useSelector((store) => store);
  const dispatch = useDispatch();

  const handleSubmit = (values) => {
    const data = {
      jwt: localStorage.getItem("jwt"),
      order: {
        resturantId: cart.cartItems[0].food?.resturant.id,
        deliveryAddress: {
          fullName: auth.user?.fullName,
          streetAddress: values.streetAddress,
          city: values.city,
          state: values.state,
          postalCode: values.pincode,
          country: "India",
        },
      },
    };
    dispatch(createOrder(data))
    console.log("form value", values);
  };

  return (
    <>
      {/* create different sections */}
      <main className="lg:flex justify-between ">
        {/* this section we add item in carts */}
        <section className="lg:w-[30%] space-y-6 lg:min-h-screen pt-10">
          {/* Rendor here CartItem Page */}
          {/* render cart items */}
          {cart.cartItems.map((item) => (
            <CartItem item={item} />
          ))}

          <Divider />

          {/* bill details */}
          <div className="bilDetails px-5 text-sm">
            <p className="font-extralight py-5 ">Bill Details</p>
            <div className="space-y-3 ">
              <div className="flex justify-between text-gray-400 ">
                <p>Item Total</p>
                <p>₹{cart.cart?.totale}</p>
              </div>
              <div className="flex justify-between text-gray-400 ">
                <p>Deliver Fee</p>
                <p>₹21</p>
              </div>
              <div className="flex justify-between text-gray-400 ">
                <p>GST & Resturant Charges</p>
                <p>₹30</p>
              </div>
              <Divider />
            </div>
            <div className="flex justify-between text-gray-400">
              <p>Total Pay</p>
              <p>₹{cart.cart?.totale + 21 + 30}</p>
            </div>
          </div>
        </section>

        <Divider orientation="vertical" flexItem />
        {/* you dont create next section verticle line cant show */}

        <section className="lg:w-[70%] flex justify-center px-5 pb-10 lg:pb-0">
          <div>
            <h1 className="text-center font-semibold text-2xl py-10">
              Coose Delivery Address
            </h1>

            <div className="flex gap-5 flex-wrap justify-center ">
              {[1, 1, 1,].map((item) => (
                <AddressCart
                  handleSelectAddress={createOrderUsingSelectedAddress}
                  item={item}
                  showButton={true}
                />
              ))}

              {/* adding new address */}
              <Card className="flex gap-5 w-64 p-5 ">
                <AddLocationIcon />
                <div className="space-y-3 text-gray-500 ">
                  <h1 className="font-semibold text-lg text-white">
                    Add New Address
                  </h1>

                  {/* hide button in addesss page */}
                  <Button
                    variant="outlined"
                    fullWidth
                    onClick={handleOpenAddessModal}
                  >
                    Add
                  </Button>
                </div>
              </Card>
            </div>
          </div>
        </section>
      </main>

      {/* you select add address open new modal    */}
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        {/* form inside this box  */}
        <Box sx={style}>
          {/* install 1st formik */}

          <Formik
            initialValues={initialValues}
            // validationSchema={validationSchema}
            onSubmit={handleSubmit}
          >
            <Form>
              {/* form completion */}
              <Grid container spacing={2}>
                <Grid item xs={12}>
                  {/* fild come for formik */}
                  <Field
                    as={TextField}
                    name="streetAddress"
                    label="Street Addresss"
                    fullWidth
                    variant="outlined"
                    // error= {!ErrorMessage("streetAddress")}
                    // helperText={
                    //     <ErrorMessage>
                    //         {(msg) => <span className='text-red-600'>{msg}</span>}
                    //     </ErrorMessage>
                    // }
                  />
                </Grid>

                <Grid item xs={12}>
                  {/* fild come for formik */}
                  <Field
                    as={TextField}
                    name="city"
                    label="City"
                    fullWidth
                    variant="outlined"
                    // error= {!ErrorMessage("streetAddress")}
                    // helperText={
                    //     <ErrorMessage>
                    //         {(msg) => <span className='text-red-600'>{msg}</span>}
                    //     </ErrorMessage>
                    // }
                  />
                </Grid>

                <Grid item xs={12}>
                  {/* fild come for formik */}
                  <Field
                    as={TextField}
                    name="state"
                    label="State"
                    fullWidth
                    variant="outlined"
                    // error= {!ErrorMessage("streetAddress")}
                    // helperText={
                    //     <ErrorMessage>
                    //         {(msg) => <span className='text-red-600'>{msg}</span>}
                    //     </ErrorMessage>
                    // }
                  />
                </Grid>

                <Grid item xs={12}>
                  {/* fild come for formik */}
                  <Field
                    as={TextField}
                    name="pincode"
                    label="Pincode"
                    fullWidth
                    variant="outlined"
                    // error= {!ErrorMessage("streetAddress")}
                    // helperText={
                    //     <ErrorMessage>
                    //         {(msg) => <span className='text-red-600'>{msg}</span>}
                    //     </ErrorMessage>
                    // }
                  />
                </Grid>

                <Grid item xs={12}>
                  <Button
                    fullWidth
                    variant="contained"
                    type="submit"
                    color="primary"
                  >
                    Deliver Here
                  </Button>
                </Grid>
              </Grid>
            </Form>
          </Formik>
        </Box>
      </Modal>
    </>
  );
};

export default Cart;
