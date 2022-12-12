import { Container, Typography, Box, Stack, Grid, Button } from "@mui/material";
// import Appbar from "./components/appbar";
import { ThemeProvider } from "@mui/system";
// import theme from "../../styles/theme";
// import Banner from "./components/banner";
import Products from "../products";
// import { UIProvider } from "./context/ui";
// import Footer from "./components/footer";
// import AppDrawer from "./components/drawer";
// import Promotions from "./components/promotions";
// import SearchBox from "./components/search";
import { useEffect } from "react";
import theme from "../../../styles/theme";
import { useParams } from "react-router-dom";


/**
 * 
 * @Author: Bich Ngoc
 */
function Category() {
  
  const {id} = useParams();
  useEffect(() => {
    document.title = "React Material UI - Home";

  }, []);
  return (
    <ThemeProvider theme={theme}>
      <Container
        disableGutters
        maxWidth="xl"
        sx={{
          background: "#fff",
        }}
      >
        <Stack>
          {/* <UIProvider>
            <Appbar />
            <Banner />
            <Promotions />
            <SearchBox /> */}
            <Box display="flex" justifyContent="center" sx={{ p: 4 }}>
              <Typography variant="h4">Our Products</Typography>
            </Box>
            <Products id={id} />
            
            {/* <Footer />
            <AppDrawer />
          </UIProvider> */}
        </Stack>
      </Container>
    </ThemeProvider>
  );
}

export default Category;
