

export const uploadImageToCloudinary = async(file) => {
  const data = new FormData();
  data.append("file", file);
  data.append("upload_preset", upload_preset);
  data.append("cloud_name", cloud_name);

  const response = await fetch(api_url, {
    method:"post",
    body:data
  });
  const fileData = await response.json();
  console.log(fileData)
  return fileData.url
};
